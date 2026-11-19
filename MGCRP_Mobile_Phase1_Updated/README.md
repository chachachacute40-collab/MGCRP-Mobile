# MGCRP Mobile — Phase 1 launcher prototype

Cyber/neon Kotlin Android launcher scaffold for Montreal Global City RolePlay.

## Current capabilities
- Branded launcher prototype and custom app icon.
- Displays the configured server endpoint `31.58.143.97:7777`.
- Placeholder Enter City, Server News and Settings actions.
- GitHub Actions workflow to build a debug APK in the cloud.

## Not a playable client yet
No SA-MP/open.mp Android game client is bundled or integrated. The launcher does not yet connect to the server, authenticate accounts, load news, or provide GTA skins, vehicles, HUD, animations or audio.

## Build without Android Studio
1. Create a GitHub repository and upload this project.
2. Open the repository's Actions tab.
3. Run **Build MGCRP Mobile** (or push to `main`).
4. Download the `MGCRP-Mobile-debug` artifact from the completed workflow.
5. Extract `app-debug.apk`, transfer it to your Android phone, and install it.

For local builds, use JDK 17, Gradle 8.9, Android SDK Platform 35 and Android build tools. Run `gradle assembleDebug` from the project root.

## Architecture
The Kotlin launcher can run on ARMv7 and ARM64 Android devices. The eventual game-client native libraries must separately supply `armeabi-v7a` and `arm64-v8a` builds.

Package: `com.mgcrp.mobile`; version: `0.1.0`; minimum Android: 7.0 (API 24).
