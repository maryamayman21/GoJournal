import com.android.build.api.dsl.ApplicationProductFlavor
import com.android.build.api.dsl.LibraryProductFlavor
import org.gradle.api.NamedDomainObjectContainer

sealed class BuildFlavor(val name: String) {
    //its used for app
    abstract fun create(namedDomainObjectContainer: NamedDomainObjectContainer<ApplicationProductFlavor>): ApplicationProductFlavor

    //used for modules
    abstract fun createLibray(namedDomainObjectContainer: NamedDomainObjectContainer<LibraryProductFlavor>): LibraryProductFlavor

    object Google : BuildFlavor(FlavorTypes.GOOGLE) {
        override fun create(namedDomainObjectContainer: NamedDomainObjectContainer<ApplicationProductFlavor>): ApplicationProductFlavor {
            return namedDomainObjectContainer.create(name) {
                versionNameSuffix = "-$name"
                applicationIdSuffix = ".$name"
                dimension = BuildDimensions.STORE
            }
        }

        override fun createLibray(namedDomainObjectContainer: NamedDomainObjectContainer<LibraryProductFlavor>): LibraryProductFlavor {
            return namedDomainObjectContainer.create(name) {
                dimension = BuildDimensions.STORE
            }
        }
    }

    object Huawei : BuildFlavor(FlavorTypes.HUAWEI) {
        override fun create(namedDomainObjectContainer: NamedDomainObjectContainer<ApplicationProductFlavor>): ApplicationProductFlavor {
            return namedDomainObjectContainer.create(name) {
                dimension = BuildDimensions.STORE
                versionNameSuffix = "-$name"
                applicationIdSuffix = ".$name"

            }
        }

        override fun createLibray(namedDomainObjectContainer: NamedDomainObjectContainer<LibraryProductFlavor>): LibraryProductFlavor {
            return namedDomainObjectContainer.create(name) {
                dimension = BuildDimensions.STORE

            }
        }

    }
    object Free: BuildFlavor(FlavorTypes.FREE) {
        override fun create(namedDomainObjectContainer: NamedDomainObjectContainer<ApplicationProductFlavor>): ApplicationProductFlavor {
            return namedDomainObjectContainer.create(name) {
                dimension = BuildDimensions.APP
                versionNameSuffix = "-$name"
                applicationIdSuffix = ".$name"

            }
        }

        override fun createLibray(namedDomainObjectContainer: NamedDomainObjectContainer<LibraryProductFlavor>): LibraryProductFlavor {
            return namedDomainObjectContainer.create(name) {
                dimension = BuildDimensions.APP

            }
        }

    }
    object Premium: BuildFlavor(FlavorTypes.Premium) {
        override fun create(namedDomainObjectContainer: NamedDomainObjectContainer<ApplicationProductFlavor>): ApplicationProductFlavor {
            return namedDomainObjectContainer.create(name) {
                dimension = BuildDimensions.APP
                versionNameSuffix = "-$name"
                applicationIdSuffix = ".$name"

            }
        }

        override fun createLibray(namedDomainObjectContainer: NamedDomainObjectContainer<LibraryProductFlavor>): LibraryProductFlavor {
            return namedDomainObjectContainer.create(name) {
                dimension = BuildDimensions.APP

            }
        }

    }

}
