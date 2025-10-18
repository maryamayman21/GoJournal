import com.android.build.api.dsl.ApplicationProductFlavor
import com.android.build.api.dsl.LibraryProductFlavor
import org.gradle.api.NamedDomainObjectContainer

sealed class BuildFlavor(name : String){
 //its used for app
 abstract fun create( namedDomainObjectContainer : NamedDomainObjectContainer<ApplicationProductFlavor>) : ApplicationProductFlavor
 //used for modules
 abstract fun createLibray( namedDomainObjectContainer : NamedDomainObjectContainer<LibraryProductFlavor>) : LibraryProductFlavor


}
