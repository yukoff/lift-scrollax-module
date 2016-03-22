package net.liftmodules

import net.liftweb._
import util.{ Props }
import http._
import common._

import org.specs2.mutable.Specification

object ScrollaxModuleSpec extends Specification  {
  "ScrollaxModuleSpec Specification".title

  java.lang.System.setProperty("run.mode", "production") // have to add this to make tests pass
  "With production and ScrollaxModule.InitParam.Scrollax the ResourceServer.pathRewriter" should {
    "having the initparam set to Scrollax100 rewrite scrollax.js to scrollax/1.0.0/js/scrollax.min.js" in {
      rewriteScrollax100JS must_== List("scrollax", "1.0.0", "js", "scrollax.min.js")
    }
    "having the initparam set to Scrollax10X rewrite scrollax.js to scrollax/1.0.0/js/scrollax.min.js" in {
      rewriteScrollax10XJS must_== List("scrollax", "1.0.0", "js", "scrollax.min.js")
    }
    "having the initparam set to ScrollaxLatest rewrite scrollax.js to scrollax/1.0.0/js/scrollax.min.js" in {
      rewriteScrollaxLatestJS must_== List("scrollax", "1.0.0", "js", "scrollax.min.js")
    }
  }
  def rewriteScrollax100JS = {
    Scrollax.InitParam.Scrollax=Scrollax.Scrollax100
    ResourceServer.pathRewriter("scrollax.js"::Nil)
  }

  def rewriteScrollax10XJS = {
    Scrollax.InitParam.Scrollax=Scrollax.Scrollax10X
    ResourceServer.pathRewriter("scrollax.js"::Nil)
  }

  def rewriteScrollaxLatestJS = {
    Scrollax.InitParam.Scrollax=Scrollax.ScrollaxLatest
    ResourceServer.pathRewriter("scrollax.js"::Nil)
  }

}
