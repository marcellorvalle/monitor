# Modularized SpringBoot with gradle

This sample code is a reference for future projects.

Each project should be configured as a "vanilla" gradle module. After the addition of the module-info.file, gradle should de configured with modularity inference (modularity.inferModulePath = true). 

The web module depends on the interface (feature-api) and is decoupled from the implementation(feature-runtime). Spring will inject the right implementation.

This is a personal preference: the implementation(feature-runtime) use one-service-per-class approach with one facade aggregating all services, simplifying the interface and providing low coupling.
