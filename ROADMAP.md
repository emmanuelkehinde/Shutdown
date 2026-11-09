# Roadmap

Shutdown still works with `onBackPressed()`, but Android has moved on. Since Android 13, `onBackPressed()` is deprecated in favour of `OnBackPressedDispatcher`. Apps that target Android 16 get predictive back by default, so `onBackPressed()` is no longer called. The build also depends on JCenter and Bintray, which have shut down. This is the work planned to bring the library up to date.

## 1. Modern build

- Update to current Gradle, Android Gradle Plugin and Kotlin versions.
- Remove the JCenter repository and the unused Bintray and `android-maven` plugins.
- Move the build scripts to the Kotlin DSL with a version catalog.
- Raise `minSdk` from 16 to 21 and `compileSdk`/`targetSdk` to the current release.
- Replace Travis CI, which no longer builds this repository, with GitHub Actions that build, lint and test every pull request.

## 2. Back handling for current Android

- Add an API built on `OnBackPressedDispatcher` and `OnBackPressedCallback`, tied to the activity's lifecycle, so apps don't need to override `onBackPressed()`.
- Support predictive back on Android 14 and later, including apps that target Android 16.
- Keep `Shutdown.now()` working for existing users, and mark it deprecated with a migration note.
- Add a Jetpack Compose entry point built on `BackHandler`.

## 3. Bug fixes

- The last back press time is shared by the whole process. A press in one activity counts toward closing a different activity if the user moves between them within the timeout. Track it per activity instead.
- The default message is a hard-coded English string. Move it to a string resource so apps can translate it.

## 4. More options

- Let apps show a Snackbar or their own UI instead of a Toast, through a callback.
- Let apps choose whether a second press finishes the activity or the whole task.

## 5. Tests and docs

- Replace the generated example tests with unit tests for the timing logic and Robolectric tests for the activity behaviour.
- Rewrite the sample app in Kotlin, with a Compose screen and a fragment example. Issue #3 asked how to use the library from a fragment.
- Publish API docs with Dokka, and add a changelog.

## 6. Releases

- Keep publishing through JitPack, and publish to Maven Central as well.
- Release 2.0.0 with the new back handling API, following semantic versioning.
