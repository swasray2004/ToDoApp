# ✅ ToDo App – Kotlin, Firebase, Voice Input & Reminders

A feature-rich ToDo app built with **Kotlin**, combining the power of **Firebase Authentication**, **Realtime Database**, **ViewBinding**, and **Navigation Component**. It enables users to manage their daily tasks with real-time syncing, voice input, due date calendar, and notifications — all wrapped in a clean and modern UI.

---

## 🚀 Features

- 🔐 **Secure Login/Signup** – Powered by Firebase Authentication
- ☁️ **Realtime Task Syncing** – Using Firebase Realtime Database
- 🧠 **CRUD Operations** – Create, Read, Update, Delete tasks
- 🗓️ **Calendar Picker** – Easily select task due dates
- 🔔 **Remind Me** – Get notified when a task is due
- 🗣️ **Google Speech-to-Text** – Add tasks using your voice
- 💡 **ViewBinding** – Efficient and type-safe view management
- 🔄 **Navigation Component** – Seamless screen transitions
- 🎨 **Material UI** – Splash screen and polished visual design
- ⏳ **Priority Support** – Option to categorize task importance

---

## 📸 Screenshots


![WhatsApp Image 2025-04-24 at 14 15 25_60085bd2](https://github.com/user-attachments/assets/d31d227f-964c-4aae-aca6-d669c669508c)
![SignIn](https://github.com/user-attachments/assets/c7484b04-b53e-4a6f-b67c-00363a9c4f60)
![SignUp](https://github.com/user-attachments/assets/49843891-4cc6-43e9-a59a-6b54132324f4)
![Home](https://github.com/user-attachments/assets/1a6ce385-5a34-4133-b3b1-6eb184bff34a)
![Update](https://github.com/user-attachments/assets/83099290-ef52-43e4-8ac4-688f93ad4e09)
![Speech](https://github.com/user-attachments/assets/f77b3ec3-266c-49a3-9497-a28c281a6076)





---

## 🛠 Tech Stack

- **Language**: Kotlin
- **Architecture**: MVVM
- **UI**: XML + ViewBinding
- **Firebase Services**:
  - Authentication
  - Realtime Database
- **APIs**: Google Speech-to-Text
- **Navigation**: Jetpack Navigation Component
- **Notifications**: AlarmManager & NotificationCompat
- **Build Tool**: Gradle

---

## 📂 Folder Structure

ToDoApp/
│
├── .idea/                         # Android Studio project settings
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/
│   │   │   │       └── example/
│   │   │   │           └── todoapp/
│   │   │   │               ├── adapter/                 # RecyclerView Adapters
│   │   │   │               ├── data/                    # Data models
│   │   │   │               ├── fragments/               # UI fragments
│   │   │   │               │   ├── SplashFragment.kt
│   │   │   │               │   ├── SignInFragment.kt
│   │   │   │               │   ├── SignUpFragment.kt
│   │   │   │               │   ├── HomeFragment.kt
│   │   │   │               │   └── AddTodoPopupFragment.kt
│   │   │   │               ├── utils/                   # Helper utilities (FirebaseHelper, Constants)
│   │   │   │               └── MainActivity.kt          # Navigation host
│   │   │   ├── res/
│   │   │   │   ├── drawable/                            # Image and vector assets
│   │   │   │   ├── layout/                              # XML layout files
│   │   │   │   │   ├── fragment_home.xml
│   │   │   │   │   ├── fragment_signin.xml
│   │   │   │   │   ├── fragment_signup.xml
│   │   │   │   │   ├── fragment_add_todo_popup.xml
│   │   │   │   │   ├── fragment_splash.xml
│   │   │   │   │   ├── item_todo.xml                   # Layout for each todo item
│   │   │   │   │   └── activity_main.xml
│   │   │   │   ├── values/
│   │   │   │   │   ├── colors.xml
│   │   │   │   │   ├── strings.xml
│   │   │   │   │   └── themes.xml
│   │   │   └── AndroidManifest.xml
│   ├── build.gradle
│
├── screenshots/                  # Screenshots for README.md
│   ├── home.png
│   ├── add.png
│   ├── voice.png
│   └── calendar.png
│
├── build.gradle                  # Top-level Gradle file
├── README.md                     # Project documentation
└── gradle.properties


