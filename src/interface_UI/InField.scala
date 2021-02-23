package interface_UI

import scala.swing._
import java.awt.Color

/**
 * Customized textfield receiving the input text to copy 
 */
class InField extends TextField {

  background = Color.WHITE
  foreground = Color.BLACK
  text = ""
  columns = 80
  border = Swing.LineBorder(Color.GRAY) 
  
}