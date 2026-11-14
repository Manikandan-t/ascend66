package app.ascend66.habits;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.RemoteViews;
import org.json.JSONObject;

public class ProgressWidget extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager manager, int[] ids) {
        for (int id : ids) update(context, manager, id);
    }

    public static void refreshAll(Context context) {
        try {
            AppWidgetManager m = AppWidgetManager.getInstance(context);
            int[] ids = m.getAppWidgetIds(new ComponentName(context, ProgressWidget.class));
            for (int id : ids) update(context, m, id);
        } catch (Exception ignored) {}
    }

    static void update(Context context, AppWidgetManager manager, int id) {
        RemoteViews v = new RemoteViews(context.getPackageName(), R.layout.widget_progress);
        int day = 1, span = 66, streak = 0, done = 0, total = 0;
        String next = "Open Ascend 66";
        try {
            SharedPreferences p = context.getSharedPreferences("CapacitorStorage", Context.MODE_PRIVATE);
            String raw = p.getString("widget", null);
            if (raw != null) {
                JSONObject o = new JSONObject(raw);
                day = o.optInt("day", 1);
                span = o.optInt("span", 66);
                streak = o.optInt("streak", 0);
                done = o.optInt("done", 0);
                total = o.optInt("total", 0);
                next = o.optString("next", next);
            }
        } catch (Exception ignored) {}
        v.setTextViewText(R.id.w_day, "Day " + Math.min(day, span));
        v.setTextViewText(R.id.w_span, " / " + span);
        v.setTextViewText(R.id.w_streak, "🔥 " + streak);
        v.setTextViewText(R.id.w_tasks, done + "/" + total + " tasks done");
        v.setTextViewText(R.id.w_next, next);
        v.setProgressBar(R.id.w_bar, Math.max(1, total), done, false);
        Intent i = new Intent(context, MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(context, 0, i,
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
        v.setOnClickPendingIntent(R.id.w_root, pi);
        manager.updateAppWidget(id, v);
    }
}
