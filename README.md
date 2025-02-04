- [English](README.md)
- [简体中文](README.zh.md)

# OpenNote

![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/kotlin-%237F52FF.svg?style=for-the-badge&logo=kotlin&logoColor=white)
![Compose](https://img.shields.io/static/v1?style=for-the-badge&message=Jetpack+Compose&color=4285F4&logo=Jetpack+Compose&logoColor=FFFFFF&label=)
![LaTeX](https://img.shields.io/badge/latex-%23008080.svg?style=for-the-badge&logo=latex&logoColor=white)
![Markdown](https://img.shields.io/badge/markdown-%23000000.svg?style=for-the-badge&logo=markdown&logoColor=white)

OpenNote is a modern Android note-taking application built entirely with Compose.  
It is developed using Kotlin (Compose) and follows the MVVM (Model-View-ViewModel) architecture
pattern along with Clean Architecture principles.

<a href="https://play.google.com/store/apps/details?id=com.yangdai.opennote">
      <img alt="Get it on Google Play" src="https://play.google.com/intl/en_us/badges/static/images/badges/en_badge_web_generic.png" height="100">
</a>

<a href="https://github.com/YangDai2003/OpenNote-Compose/releases">
      <img alt="Get it on GitHub" src="https://raw.githubusercontent.com/deckerst/common/main/assets/get-it-on-github.png" height="100">
</a>

## How to Use OpenNote with Markdown, LaTeX Math, and Mermaid Diagrams?

You can know more about how to use OpenNote with Markdown, LaTeX Math, and Mermaid Diagrams in
the [Guide](Guide.md).

## Features

- **Create, Edit, and Delete Notes**: Users can create, edit, and delete notes effortlessly.
- **Create, Edit, and Delete Folders**: Organize notes efficiently with folder management
  functionalities.
- **Sorting and Filtering**: Easily sort and filter notes and folders based on various criteria.
- **Move Notes**: Seamlessly move notes between different folders for better organization.
- **Trash Bin**: Safely move notes to the trash for temporary storage before permanent deletion.
- **OCR Text Recognition**: Utilizes ML Kit and CameraX for optical character recognition (OCR)
  directly from images.
- **Markdown Support**: Supports both CommonMark and GitHub Flavored Markdown (GFM) syntax for
  versatile formatting options.
- **LaTeX Math Support**: Supports LaTeX math syntax for mathematical equations.
- **Mermaid Diagram Support**: Supports Mermaid syntax for creating diagrams and flowcharts.
- **Light Mode**: Provides basic Markdown syntax and real-time preview.
- **Standard Mode**: Offers comprehensive Markdown syntax and precise rendering, with separate editing and reading areas.
- **Export Options**: Notes can be exported in various formats, including TXT, MD (Markdown), and HTML for versatile sharing and usage.
- **Material 3 Design**: Adheres to Material Design guidelines, creating a modern and cohesive user interface.
- **Responsive Design**: Optimized for devices with different screen sizes and orientations, providing a great experience on phones, tablets, and even foldable devices.

## Screenshots

<div style="overflow-x: auto; white-space: nowrap;">

<img src="screenshots/Screenshot_Login.PNG" width="15%" alt=""/>
<img src="screenshots/Screenshot_Grid.PNG" width="15%" alt=""/>
<img src="screenshots/Screenshot_List.PNG" width="15%" alt=""/>
<img src="screenshots/Screenshot_Drawer.PNG" width="15%" alt=""/>
<img src="screenshots/Screenshot_Edit.PNG" width="15%" alt=""/>
<img src="screenshots/Screenshot_Preview.PNG" width="15%" alt=""/>
<img src="screenshots/Screenshot_Style.PNG" width="15%" alt=""/>
<img src="screenshots/Screenshot_Data.PNG" width="15%" alt=""/>
<img src="screenshots/Screenshot_Widget.PNG" width="15%" alt=""/>
<img src="screenshots/Screenshot_Math_Edit.png" width="15%" alt=""/>
<img src="screenshots/Screenshot_Math_Preview.png" width="15%" alt=""/>
<img src="screenshots/Screenshot_Mermaid_Edit.png" width="15%" alt=""/>
<img src="screenshots/Screenshot_Mermaid_Preview.png" width="15%" alt=""/>
<img src="screenshots/Screenshot_Large_Screen.png" width="32%" alt=""/>
<img src="screenshots/Screenshot_Large_Screen_Edit_Preview.png" width="32%" alt=""/>

</div>

## Technical Details

- **Programming Languages**: Kotlin
- **Build Tool**: Gradle with Kotlin DSL
- **Android Version**: The application targets Android SDK version 35 and is compatible with devices
  running Android SDK version 29 and above.
- **Kotlin Version**: The application uses Kotlin version 2.1.0.
- **Java Version**: The application uses Java version 17.

## Architecture

- **MVVM (Model-View-ViewModel)**: Separates the user interface logic from the business logic,
  providing a clear separation of concerns.
- **Clean Architecture**: Emphasizes separation of concerns and layers of abstraction, making the
  application more modular, scalable, and maintainable.

## Libraries and Frameworks

- **Compose**: A modern toolkit for building native Android UI.
- **Hilt**: A dependency injection library for Android.
- **KSP (Kotlin Symbol Processing API)**: Enhances Kotlin compilation with additional metadata
  processing.
- **Room**: A persistence library providing an abstraction layer over SQLite.
- **Compose Navigation**: Simplifies the implementation of navigation between screens.
- **Material Icons**: Provides Material Design icons for consistent visual elements.
- **ML Kit**: Utilized for OCR text recognition.
- **CameraX**: Used for custom camera functionality.

## Privacy Policy and Required Permissions

You can find the Privacy Policy and Required Permissions in the [Privacy Policy](PRIVACY_POLICY.md).

## Installation

To build and run this application, you need to install the latest version of Android Studio. Then,
you can clone this repository from GitHub and open it in Android Studio.

```bash
git clone https://github.com/YangDai2003/OpenNote.git
```

In Android Studio, select `Run > Run 'app'` to start the application.

## Contribution

Any form of contribution is welcome! If you find a bug or have a new feature request, please create
an issue. If you want to contribute code directly to this project, you can create a pull request.

## References

- [MaskAnim](https://github.com/setruth/MaskAnim): Implementation of the theme switching function
  using mask animation.