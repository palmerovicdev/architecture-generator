# Clean-Architecture Plugin

Generate the Clean-Architecture directory structure from Robert C. Martin (Uncle Bob) in your flutter projects.
It is inspired by @ResoCoder [Clean Architecture for Flutter Course](https://github.com/ResoCoder/flutter-tdd-clean-architecture-course).

## How To Install
- Android Studio / IntelliJ IDEA -> Plugins -> Browse repositories
- Search: Clean Architecture for Flutter
- Install
- Restart IDE

## How To Use
- Right click on or anywhere in your destination folder
- New -> Clean Generator -> Flutter/Spring/Hexagonal/Onion/Mvc
- Enter [feature_name] in the dialog or let it be empty to create structure in current directory (Flutter and Hexagonal cases)
- Optional: Use the checkbox to split the data_sources folder into local and remote (Flutter case)

Right-click | Enter [feature_name]                   | generated  
------------ |----------------------------------------| -------------
![context menu](/assets/01-Screen.png) | ![context menu](/assets/02-Screen.png) | ![context menu](/assets/03-Screen.png)

## What will be created

### Flutter case
- [feature_name]
    - data
        - [Two variants]
            - [Checkbox checked]
                - local
                    - data_sources
                    - models
                - remote
                    - data_sources
                    - models
            - [Checkbox unchecked]
                - data_sources
                - models
        - repositories
    - domain
        - entities
        - use_cases
        - repositories
    - presentation
        - manager
        - pages
        - widgets

### Spring case
- config
- middelware
- controller
- repository
- model
  - entity
  - request
  - response
- service
- util
- core
  - enum
  - common

### Hexagonal case
- infrastructure
  - adapter.input
  - adapter.output
  - repository
  - entity
  - mapper
- application
  - port.input
  - port.output
  - service
- domain
  - model
- common
  - enum
  - interface

### Onion case
- presentation
- persistence
- infrastructure
- application-services
    - domain-services
    - domain-models

### Mvc case
- model
- vire
- controller

## Source
- https://8thlight.com/blog/uncle-bob/2012/08/13/the-clean-architecture.html
- https://resocoder.com/2019/08/27/flutter-tdd-clean-architecture-course-1-explanation-project-structure/