# Architecture Plugin

<!-- Plugin description -->
This plugin, inspired by the Clean-Architecture Plugin developed by Tyxz, provides a powerful tool for generating directory structures for five distinct architectural patterns directly within your project. Whether you're working, this plugin can streamline your development process by automatically creating the necessary directory structure based on the chosen architectural pattern. With this plugin, you can focus more on writing code and less on setting up your project's directory structure.

It is based on Clean-Architecture Plugin of [Tyxz](https://github.com/Tyxz/clean_architecture_plugin).
<!-- Plugin description end -->

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
  - adapter
      - input
      - output
  - repository
  - entity
  - mapper
- application
  - port
      - input
      - output
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
