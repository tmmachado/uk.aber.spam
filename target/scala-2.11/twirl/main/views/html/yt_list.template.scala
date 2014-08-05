
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
object yt_list extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.19*/("""

"""),_display_(/*3.2*/main("Year tutor list")/*3.25*/(message)/*3.34*/ {_display_(Seq[Any](format.raw/*3.36*/("""
	"""),format.raw/*4.2*/("""<script src=""""),_display_(/*4.16*/routes/*4.22*/.Assets.at("javascripts/script_year_tutor.js")),format.raw/*4.68*/("""" type="text/javascript"></script>
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
	    		<th class="name">NAME<br/>
	    			<img src=""""),_display_(/*19.20*/routes/*19.26*/.Assets.at("images/arrowup.png")),format.raw/*19.58*/("""" title="Order" class="btn_order asc" />
	    			<img src=""""),_display_(/*20.20*/routes/*20.26*/.Assets.at("images/arrow-down.png")),format.raw/*20.61*/("""" title="Order" class="btn_order desc" />
	    		</th>
	    		<th class="">REFERENCE</th>
	    		<th class="sop">STAGE OF PROCESS</th>
	    		<th class="datetime_meeting">MEETING<br/>
	    			<img src=""""),_display_(/*25.20*/routes/*25.26*/.Assets.at("images/arrowup.png")),format.raw/*25.58*/("""" title="Order" class="btn_order asc" />
	    			<img src=""""),_display_(/*26.20*/routes/*26.26*/.Assets.at("images/arrow-down.png")),format.raw/*26.61*/("""" title="Order" class="btn_order desc" />
	    		</th>
	    		<th class="overall">OVERALL<br/>
	    			<img src=""""),_display_(/*29.20*/routes/*29.26*/.Assets.at("images/arrowup.png")),format.raw/*29.58*/("""" title="Order" class="btn_order asc" />
	    			<img src=""""),_display_(/*30.20*/routes/*30.26*/.Assets.at("images/arrow-down.png")),format.raw/*30.61*/("""" title="Order" class="btn_order desc" />
	    		</th>
	    	</thead>
	    	<tbody>
	    	</tbody>
	    </table>
	</div>

    <div id="hidden_actions" title="Outcome meeting">
    	<div id="progressbar"></div>
		<form id="form_outcome" action=""""),_display_(/*40.36*/routes/*40.42*/.YearTutorController.updateOutcome()),format.raw/*40.78*/("""" method="post" >
			<fieldset>
				<input type="hidden" name="stud_ref" id="stud_ref" />
				<input type="hidden" name="stud_uid" id="stud_uid" />
				<input type="hidden" name="stud_name" id="stud_name" />
				<input type="hidden" name="id_meeting" id="id_meeting" />
				<input type="hidden" name="cur_year" id="cur_year" />
				<input type="hidden" name="responsible_uid" id="responsible_uid" />

				<span>Student: <span id="meeting_for"></span></span>
				<br />
				<input type="checkbox" id="absent" name="absent"/>Tick if student did not come<br />
				<div id="form_group">
					<label for="date">Date</label>
					<input type="text" name="date" id="date" readonly="readonly"/>
					<br />

					<label for="hour">Time</label>
					<input type="text" name="hours" id="hours" readonly="readonly" class="time-spinner" />:
					<input type="text" name="minutes" id="minutes" readonly="readonly" class="time-spinner" />
					<span class="example">(08:00 - 18:00)</span>
					<br />

					<label for="outcome">Outcome</label><br />
					<textarea id="outcome" name="outcome" class="outcome"></textarea>
				</div>

				<input type="button" id="btn_updateOutcome" value="Submit" />
			</fieldset>
		</form>
    </div>
""")))}),format.raw/*71.2*/("""
"""))}
  }

  def render(message:String): play.twirl.api.HtmlFormat.Appendable = apply(message)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (message) => apply(message)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Aug 05 16:23:01 BST 2014
                  SOURCE: /Users/TarcioMac/Development/PlayProjects/uk.aber.spam/app/views/yt_list.scala.html
                  HASH: 255de2f32bae3b060a985d8fedf38a89dc19ec51
                  MATRIX: 725->1|830->18|858->21|889->44|906->53|945->55|973->57|1013->71|1027->77|1093->123|1441->444|1456->450|1509->482|1596->542|1611->548|1667->583|1802->691|1817->697|1870->729|1957->789|1972->795|2028->830|2258->1033|2273->1039|2326->1071|2413->1131|2428->1137|2484->1172|2625->1286|2640->1292|2693->1324|2780->1384|2795->1390|2851->1425|3123->1670|3138->1676|3195->1712|4448->2935
                  LINES: 26->1|29->1|31->3|31->3|31->3|31->3|32->4|32->4|32->4|32->4|43->15|43->15|43->15|44->16|44->16|44->16|47->19|47->19|47->19|48->20|48->20|48->20|53->25|53->25|53->25|54->26|54->26|54->26|57->29|57->29|57->29|58->30|58->30|58->30|68->40|68->40|68->40|99->71
                  -- GENERATED --
              */
          