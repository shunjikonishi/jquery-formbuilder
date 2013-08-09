import play.api.Application;
import play.api.GlobalSettings;
import play.api.Play.current;
import play.api.Logger;
import jp.co.flect.util.ResourceGen;
import java.io.File;

object Global extends GlobalSettings {
	
	override def onStart(app: Application) {
		//Generate messages and messages.ja
		val defaults = new File("conf/messages");
		val origin = new File("conf/messages.origin");
		if (origin.lastModified > defaults.lastModified) {
			val gen = new ResourceGen(defaults.getParentFile(), "messages");
			gen.process(origin);
		}
	}
}
