package interface_UI

import scala.swing._ 

import event._
import java.awt.Color
/** A button for realizing a text-copy
 * @param lab the label of the button
 * @param from the Infield from which the text is copied
 * @param to the ResultText to which the text is copied
 */
class SendButton(lab: String, from : InField, to : ScrollPane, then:Response) extends Button {

  text = lab
  val z = new MainPanel
  val temp = z.p
  // Ajout d'une reaction au clic sur le bouton
  // c'est à dire copier le contenu du champ from dans le label de to.
  reactions += {

    case ButtonClicked(_) => {
    

      if (from.text != "") {
        /*then.text += "\n"+" Response :" + " salut !"+"\n"
   
        to.text += "\n" + " Question : " + from.text + "\n" 

        from.text = ""*/
        
        /*to.main.contents = new BoxPanel(Orientation.Vertical){
          contents += new TextArea("Question : " + from.text  + "\n" + "Réponse :")
   
        }
        from.text = ""*/
        
        temp.contents += new TextArea("Question : " + from.text)
        temp.contents += new TextArea("Réponse : " + Implementations.MachineImpl.ask(from.text))
        
        to.contents = temp
          
          
   
        
        from.text = ""
        
       

      }
        
      }
  }
  
}