package net.liftmodules

import net.liftweb._
import util.{ Props }
import http._
import common._

/**
 * This package object provides Scrollax integration into your Lift application.
 */
package object Scrollax {

  /**
   * @example In bootstrap liftweb Boot set
   * {{{
   *   Scrollax.init()
   * }}}
   * The above example just calls init without specifying init
   * params so the default Scrollax version will be used.
   */
  def init() {
    LiftRules.addToPackages("net.liftmodules.Scrollax")
    ResourceServer.allow {
      case "scrollax.js" :: nil => true
    }
  }

  abstract sealed trait Resource
  /**
   * Enable Scrollax options in your bootstrap liftweb Boot
   *
   * '''Example:''
   *
   * {{{
   *   //init params can be skipped if it sets the current default value
   *   Scrollax.InitParam.Scrollax=Scrollax.Scrollax100
   *   Scrollax.init()
   * }}}
   * This example is explicitly setting the scrollax init param
   * Using the default you could alternatively just call Scrollax.init()
   *
   * '''Example:'''
   *
   * {{{
   *   Scrollax.InitParam.Scrollax=Scrollax.Scrollax100
   * }}}
   */
  object InitParam extends Resource {
    var Scrollax: Resource = _
  }


  /**
   * Enable usage of Scrollax version 1.0.x in your bootstrap liftweb Boot.
   * @version 1.0.x
   * WARNING! As Scrollax.JS depend on JQuery it won't work with Internet Explorer 6, 7, or 8
   *          when used with JQuery 2.x
   *
   * '''Example:'''
   *
   * {{{
   *   Scrollax.InitParam.Scrollax=Scrollax.Scrollax10X
   * }}}
   * @since v1.0
   */
  case object Scrollax10X extends Resource {
    ScrollaxResources.scrollax100
  }

  /**
   * Enable usage of Scrollax version 1.0.0 in your bootstrap liftweb Boot.
   * @version 1.0.0
   * WARNING! As Scrollax.JS depend on JQuery it won't work with Internet Explorer 6, 7, or 8
   *          when used with JQuery 2.x
   *
   * '''Example:'''
   *
   * {{{
   *   Scrollax.InitParam.Scrollax=Scrollax.Scrollax100
   * }}}
   * @since v1.0
   */
  case object Scrollax100 extends Resource {
    ScrollaxResources.scrollax100
  }

   /**
   * Enable usage of Scrollax latest version in your bootstrap liftweb Boot.
   * @version 1.0.0 (annotated as 1.0.0-3-g9119299)
   * WARNING! As Scrollax.JS depend on JQuery it won't work with Internet Explorer 6, 7, or 8
   *          when used with JQuery 2.x
   *
   * '''Example:'''
   *
   * {{{
   *   Scrollax.InitParam.Scrollax=Scrollax.ScrollaxLatest
   * }}}
   * @since v1.0
   */
  case object ScrollaxLatest extends Resource {
    ScrollaxResources.scrollax100
  }


  /**
   * Object that holds internally used module resources.
   */
  private object ScrollaxResources {

    lazy val scrollax100 = {
      ResourceServer.rewrite {
        case "scrollax.js" :: Nil if Props.devMode => List("scrollax", "1.0.0", "js", "scrollax.js")
        case "scrollax.js" :: Nil => List("scrollax", "1.0.0", "js", "scrollax.min.js")
        case "scrollax.min.map" :: Nil => List("scrollax", "1.0.0", "js", "scrollax.min.map")
      }
    }

  }

}
