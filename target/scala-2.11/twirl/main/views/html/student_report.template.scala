
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._

/**/
object student_report extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.19*/("""

"""),_display_(/*3.2*/main("Student report")/*3.24*/(message)/*3.33*/ {_display_(Seq[Any](format.raw/*3.35*/("""
	"""),format.raw/*4.2*/("""<script src=""""),_display_(/*4.16*/routes/*4.22*/.Assets.at("javascripts/script_admin.js")),format.raw/*4.63*/("""" type="text/javascript"></script>
	<div class="main">
	    <table class="report">
	    	<caption>
	    		<span class="table-title">Students with more than 50% absence</span>
	    		<br />
	    		From last 120 days
	    	</caption>
	    	<thead>
	    		<th>Actions</th>
	    		<th class="uid">UID<br/>
	    			<img src=""""),_display_(/*15.20*/routes/*15.26*/.Assets.at("images/arrowup.png")),format.raw/*15.58*/("""" title="Order" class="btn_order asc" />
	    			<img src=""""),_display_(/*16.20*/routes/*16.26*/.Assets.at("images/arrow-down.png")),format.raw/*16.61*/("""" title="Order" class="btn_order desc" />
	    		</th>
	    		<th class="name">
	    			NAME<br/>
	    			<img src=""""),_display_(/*20.20*/routes/*20.26*/.Assets.at("images/arrowup.png")),format.raw/*20.58*/("""" title="Order" class="btn_order asc" />
	    			<img src=""""),_display_(/*21.20*/routes/*21.26*/.Assets.at("images/arrow-down.png")),format.raw/*21.61*/("""" title="Order" class="btn_order desc" />
	    		</th>
	    		<th class="">COURSE</th>
	    		<th class="">YEAR</th>
	    		<th class="yos">
	    			YEAR OF STUDY
	    			<img src=""""),_display_(/*27.20*/routes/*27.26*/.Assets.at("images/filter.png")),format.raw/*27.57*/("""" title="Filter" class="btn_filter" />
	    			<input id="hidden_filter" type="text" />
	    		</th>
	    		<th class="repeating">REPEATING</th>
	    		<th class="sop">STAGE OF PROCESS</th>
	    		<th class="">SESSIONS FOR PERIOD</th>
	    		<th class="overall">
	    			OVERALL<br/>
	    			<img src=""""),_display_(/*35.20*/routes/*35.26*/.Assets.at("images/arrowup.png")),format.raw/*35.58*/("""" title="Order" class="btn_order asc" />
	    			<img src=""""),_display_(/*36.20*/routes/*36.26*/.Assets.at("images/arrow-down.png")),format.raw/*36.61*/("""" title="Order" class="btn_order desc" />
	    		</th>
	    	</thead>
	    	<tbody>
	    	</tbody>
	    </table>
	</div>

	    <div id="hidden_actions" title="Arrange meeting">
	    	<div id="progressbar"></div>
			<form id="arrange_meeting" action=""""),_display_(/*46.40*/routes/*46.46*/.AdminController.arrangeMeeting()),format.raw/*46.79*/("""" method="post" >
				<fieldset>
					<input type="hidden" name="stud_ref" id="stud_ref" />
					<input type="hidden" name="stud_name" id="stud_name" />
					<input type="hidden" name="stud_uid" id="stud_uid" />
					<input type="hidden" name="responsible_uid" id="responsible_uid" />
					<input type="hidden" name="responsible_name" id="responsible_name" />
					<input type="hidden" name="year_of_study" id="year_of_study" />
					<input type="hidden" name="stage_of_process" id="stage_of_process" />
					<input type="hidden" name="responsible" id="responsible" />

					For: <span id="meeting_for"></span><br />
		    		With: <span id="meeting_with"></span><br />

					<label for="date">Date</label>
					<input type="text" name="date" id="date" readonly="readonly"/>
					<br />
					<label for="hour">Time</label>
					<input type="text" name="hours" id="hours" value="08" readonly="readonly" class="time-spinner" />:
					<input type="text" name="minutes" id="minutes" value="00" readonly="readonly" class="time-spinner" />
					<span class="example">(08:00 - 18:00)</span>
					<br />
					<label for="location">Location</label>
					<input type="text" name="location" id="location" />
					<br />
					<input type="button" id="btn_sendEmail" value="Submit" />
				</fieldset>
			</form>
	    </div>

""")))}),format.raw/*76.2*/("""
"""))}
  }

  def render(message:String): play.twirl.api.HtmlFormat.Appendable = apply(message)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (message) => apply(message)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Aug 05 15:53:23 BST 2014
                  SOURCE: /Users/TarcioMac/Development/PlayProjects/uk.aber.spam/app/views/student_report.scala.html
                  HASH: 5b78f7ec2cfd70a5b34543684c7fdb418b930468
                  MATRIX: 732->1|837->18|865->21|895->43|912->52|951->54|979->56|1019->70|1033->76|1094->117|1442->438|1457->444|1510->476|1597->536|1612->542|1668->577|1812->694|1827->700|1880->732|1967->792|1982->798|2038->833|2247->1015|2262->1021|2314->1052|2644->1355|2659->1361|2712->1393|2799->1453|2814->1459|2870->1494|3148->1745|3163->1751|3217->1784|4559->3096
                  LINES: 26->1|29->1|31->3|31->3|31->3|31->3|32->4|32->4|32->4|32->4|43->15|43->15|43->15|44->16|44->16|44->16|48->20|48->20|48->20|49->21|49->21|49->21|55->27|55->27|55->27|63->35|63->35|63->35|64->36|64->36|64->36|74->46|74->46|74->46|104->76
                  -- GENERATED --
              */
          