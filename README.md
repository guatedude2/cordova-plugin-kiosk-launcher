# cordova-plugin-kiosk-launcher

> This plugin makes a cordova app become a launcher (homescreen).

_Based of [https://github.com/hkalina/cordova-plugin-kiosk]._

Sets a Cordova application as a launcher

**This plugin does not change behavior of application until it is set as launcher - home screen of the device.**

Escape from app with this plugin is possible only using javascript call `Kiosk.exitKiosk()`
or by uninstalling app using `adb`. (Keeping USB debug allowed recommended.)
If applications starts as usual (not as launcher), no restrictions are applied.

**This plugin only works on Android**


This plugin has only been tested in Cordova 3.2 or greater, and its use in previous Cordova versions is not recommended (potential conflict with keyboard customization code present in the core in previous Cordova versions).

- [Installation](#installation)
- [Methods](#methods)
    - [Kiosk.setKiosEnabled](#kioskSetKioskEnabled)
    - [Kiosk.switchLauncher](#kioskSwitchLauncher)
    - [Kiosk.isInKiosk](#kioskIsInKiosk)
    - [Kiosk.isSetAsLauncher](#kioskIsSetAsLauncher)
- [Releases](#releases)

# Installation

From [npm](https://www.npmjs.com/package/cordova-plugin-kiosk-launcher) (stable)

`cordova plugin add cordova-plugin-kiosk-launcher`

From github latest (may not be stable)

`cordova plugin add https://github.com/guatedude2/cordova-plugin-kiosk-launcher`


# Methods

## Kiosk.setKioskEnabled

Enables/disables kiosk mode and

    Kiosk.setKioskEnabled(boolean);


## Kiosk.switchLauncher

Disables kiosk mode and allows you set a different launcher

    Kiosk.switchLauncher();


## Kiosk.isInKiosk

Checks to see if the app is running in kiosk mode

    Kiosk.isInKiosk(function(isInKiosk){ ... })

## Kiosk.isSetAsLauncher

Checks to see if the app is set as a launcher

    Kiosk.isSetAsLauncher(function(isSetAsLauncher){ ... })

# Releases
- 1.0.3
    - Removes fullscreen bug
- 1.0.2
    - Fixes wrong filename
    - Fixes KisokActivity not running
- 1.0.0
   - Initial NPM release
