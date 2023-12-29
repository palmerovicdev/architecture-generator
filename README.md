# Architecture Plugin

Generate the Architecture directory structure for 5 diferents architecture patterns in your project.
It is based on Clean-Architecture Plugin of [Tyxz](https://github.com/Tyxz/clean_architecture_plugin).

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

| Right-click                           | Go to new                             | Go to generate and click              |
|---------------------------------------|---------------------------------------|---------------------------------------|
| ![context menu](/asset/01-Screen.png) | ![context menu](/asset/02-Screen.png) | ![context menu](/asset/03-Screen.png) |

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