# ClientBase

## Why?
I made this for learning and for use in my private client [ZWare.cc](https://discord.gg/9PjbbhS).

## TO-DO

* [ ] Add ClickGUI
* [ ] Add HUD and HUDEditor

## How to use?
1. Clone the repository using `git clone https://github.com/ZWareDevelopment/ClientBase.git <YOUR CLIENT NAME>`
2. Open the project in your preferred IDE.
3. Run
    - On Linux/Mac:
        - For IntelliJ: `./gradlew setupDecompWorkspace genIntellijRuns`
        - For Eclipse: `./gradlew setupDecompWorkspace eclipse`
    - On Windows:
        - For IntelliJ: `gradlew.bat setupDecompWorkspace genIntellijRuns`
        - For Eclipse: `gradlew.bat  setupDecompWorkspace eclipse`
4. Reimport Gradle and restart your IDE.
5. Rename `dev.zihasz.clientbase` to `me.<YOUR NAME>.<CLIENT NAME>`
6. Change `dev.zihasz.clientbase.feature.module.modules` to `me.<YOUR NAME>.<CLIENT NAME>.feature.module.modules` in `ModuleManager`
7. Do the same thing in `CommandManager`
8. Add modules/make changes.
9. DiscordRPC (Optional):
    1. Go to the [Discord Developer Portal](https://discord.com/developers/)
    2. Create a new app.
    3. Add an image to the app.
    4. Go to Rich Presence.
    5. Add an image there too.
    6. Go to art assets
    7. Copy your **client ID** from the Developer portal
    8. Put your ID in the DiscordPresence class into the `APP_ID` variable
    9. Add an image named large, and an image named small to the assets.
    10. Change `detail`, `state`, `largeImageText` and `smallImageText` to something else.
