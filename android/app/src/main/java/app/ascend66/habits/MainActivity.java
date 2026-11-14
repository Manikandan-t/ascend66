package app.ascend66.habits;

import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {
    @Override
    public void onPause() {
        super.onPause();
        // Refresh the home-screen widget with the latest progress whenever the app goes to background
        ProgressWidget.refreshAll(this);
    }
}
