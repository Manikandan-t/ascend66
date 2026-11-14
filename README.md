# Ascend 66

A free, offline, gamified 66-day habit quest app. No account, no sync, no ads, no subscription. All data stays on the phone.

Features: 66-day program with personalised onboarding, daily quests with logged amounts, XP / levels / ranks, five attributes (Strength, Wisdom, Confidence, Discipline, Focus), dungeons, loot + coins + shop (streak freeze), Hard Mode with penalties, motivation cards, 56 achievements, and 7 mini tools (focus timer, meditation, screen blocker, workout tracker, calorie tracker, book summary, journal). Android extras: home-screen widget (Day X/66, streak, tasks done), smart reminders (morning summary, 9pm "streak at risk" only if tasks are left, per-task times), timers that finish with a notification even when the screen is off, back-button navigation, haptics.

Data: stored on the phone (Capacitor Preferences + photos as files). Export a backup file (with photos) from Settings and import it on another phone.

Also: weekly +10% ramp for number targets, edit yesterday's ticks until midnight, Journey timeline with mood/photos/journal, My Rating, and a shareable Day 66 recap image.

## Get the Android APK (easiest, no Android Studio)
1. Create a new GitHub repo and push this folder to it (branch `main`).
2. Open the repo's **Actions** tab, run **Build Android APK** if it has not started.
3. When it finishes (about 5 minutes), download the `Ascend66-debug-apk` artifact, unzip it, and install `app-debug.apk` on your phone (allow "install unknown apps").

## Build locally
Requires Node 22+, JDK 21 and Android Studio / SDK:
```
npm install
npm run build:android
```
APK: `android/app/build/outputs/apk/debug/app-debug.apk`

## Or install as a PWA
Host the `www/` folder anywhere on HTTPS (e.g. GitHub Pages), open it in Chrome on Android and choose **Add to Home screen**. It works offline. Reminders need the APK.

## Credits
Icons: Phosphor Icons (MIT). Font: Outfit (OFL). App icon and all other art are original.
