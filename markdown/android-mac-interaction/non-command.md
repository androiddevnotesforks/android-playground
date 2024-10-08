# How to share the clipboard between an emulator and macOS
## macOS ➡️ emulator
1. Copy text on macOS.
1. Long-tap in a text box of an app on an emulator.

## emulator ➡️ macOS
1. Copy text on an emulator.
1. Paste in an editor on macOS.

# How to transfer a file or a folder between an emulator and macOS
## macOS ➡️ emulator
1. Drag a file or a folder on macOS.
1. Drop it on an emulator.

## emulator ➡️ macOS
```shell
adb pull /sdcard/<path-to-file>
```

Alternatively, use Device File Explorer of Android Studio.

# How to enable a microphone in an emulator
Android emulator > [Extended controls](https://developer.android.com/studio/run/emulator-extended-controls)  > `Microphone` > `Virtual microphone uses host audio input`

# OEM unlocking
Android emulators don't have the `OEM unlocking` option in `Developer options`.
