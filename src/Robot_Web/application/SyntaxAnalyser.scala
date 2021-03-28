package Robot_Web.application
import Robot_Web.library._
import Implementations._

object SyntaxAnalyser {
  
  val keywords:List[String]=List("restaurant","creperie","pizzeria","restaurante","ristorante")
  
  /**
   * @param s une requête (sous forme de string)
   * @return l'expression associée à cette même requête
   */
  def ExpressionResponse(s:String):Expression={
    String2Exp(nomRestaurant(s))
  }
  
<<<<<<< HEAD
  def motsClefs(s:String):List[String] = {
    val l:List[String] = AnalysePhraseImpl.hash(s)
    var liste_copie:List[String]= AnalysePhraseImpl.hash(s)
    for(elt1 <- l) {
      for(elt2 <- keywords) {
        if(Tolerance.correct(elt1, elt2)) 
          liste_copie = liste_copie.tail ; 
          if(liste_copie(0).equalsIgnoreCase("de") || liste_copie(0).equalsIgnoreCase("du")) liste_copie=liste_copie.tail
          liste_copie
      }
      liste_copie = liste_copie.tail
=======
  /**
   * @param s une requête (sous forme de string)
   * @return la liste de strings contenant le nom du restaurant
   */
  def nomRestaurant(s:String):List[String] = {
    nameExtract(AnalysePhraseImpl.hash(s))
  }
  
  /**
   * @param l une liste non vide de strings
   * @return le nom associé au restaurant 
   */
  def nameExtract(l:List[String]):List[String] = {
    l match {
      case Nil => Nil
      case chaine :: reste => 
        for(elt <- SyntaxAnalyser.keywords) {
          if(Tolerance.correct(chaine, elt)) return reste
        }
        nameExtract(reste)
    }
  }
  
  /**
   * @param l une liste non vide de strings non vide
   * @return une expression correspondant à la requête
   */
  def String2Exp(l:List[String]):Expression = {
    l match {
      case Nil => Word("")
      case chaine :: Nil => Word(chaine)
      case chaine :: reste => And(Word(chaine),String2Exp(reste))
    }
  }
  
  /**
   * @param e un paramètre d'entrée de type expression
   * @return la string correspondant à la construction de l'url associée à l'expression e
   */
  def UrlBuilder(e: Expression): String={
    var UrlSearch: String = ""
    e match{
      case And(a,b) => UrlSearch = UrlSearch + UrlBuilder(a) + "+" + UrlBuilder(b)
      case Or(a, b) => UrlSearch = UrlSearch + UrlBuilder(a) + "&" + UrlBuilder(b)
      case Word(a) => UrlSearch = UrlSearch + a
    }
    UrlSearch
  }
<<<<<<< HEAD
=======
  
>>>>>>> branch 'avec_librairies' of https://gitlab.istic.univ-rennes1.fr/nzhang/gen21-1a-avatar-equipe1.git
}