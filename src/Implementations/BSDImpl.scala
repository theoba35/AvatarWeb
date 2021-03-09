package Implementations
import scala.io.Source
import machine.BaseDeDonnée

object BSDImpl extends BaseDeDonnée{
  
/**Retoure les noms et adresse associé aux mots clé
 * @param l liste des mots cl de la requête
 * @return la liste des nom et adresse associé aux mots clé de la requêtee
 */
   def respond(l:List[String]):List[(String,String)]={
    val t = listKeyWords
    var res:List[(String,String)]=List()
    var count:Int = 0
    val tol = new Array[Int](t.size)
    for(x<-0 to t.size-1){
      tol(x)=0
    }
    for(y<-l){
      for(z<-0 to t.size-1){
        for(w<-t(z)){
          if(w.toLowerCase().contains(y.toLowerCase())) tol(z)+=1
        }
      }
    }
    
    
    for(v<-0 to tol.size-1){
      if(v==tol.max && tol.max>0){
        res = res:+(listPaireNomAdd(v)(0),listPaireNomAdd(v)(1))
      }
    }
    res
  }
  
  /** Extracteur de fichier
   *  @param Aucun parametre, Assurez l'existence de "doc/DonneesInitiales.txt"
   *  @return une list tel que :>> List(List(nom,adresse)) */
  
  def listPaireNomAdd:List[List[String]]={
      var res :List[List[String]] = List()
      val txt =Source.fromFile("doc/DonneesInitiales.txt").getLines
      for(x<-txt){
        val i = x.indexOf(";")
        res = res :+ List(x.slice(0, i),x.slice(i+1,x.length))
      }
      res

}
  def listBanWord:List[String]={
      var res :List[String] = List()
      val txt =Source.fromFile("doc/banwords.txt").getLines
      for(x<-txt){
        res = res ++ List(x)
      }
      res

}
    /** Creer une liste de liste de mots-clés des nom à partir de listPaireNomAdd. 
     *  La liste a une indexation egale a listPaireNomAdd pour retrouvrer la paire nom Adresse à partir des mots clé
   *  @param Aucun parametre, Assurez l'existence de "doc/DonneesInitiales.txt"
   *  @return une list tel que :>> List(List(mots_cle1,mots_cle3....)) */
  
   def listKeyWords:List[List[String]]={
     var res :List[List[String]] = List()
     val list = listPaireNomAdd
     var keyWord :String =""
     for(x<-list){
         res = res :+ KeyWords(x(0))
     }
     res
   }
   
   /** Creer un list de mots-clés à partir d'une string
   *  @param Aucun parametre, Assurez l'existence de "doc/DonneesInitiales.txt"
   *  @return une list tel que :>> List(mots_cle1,mots_cle3....)) */
   
   def KeyWords(flag:String):List[String]={
     var res:List[String] = List()
     var str = flag
     val ban = listBanWord
     while(str != ""){
        val i = str.indexOf(" ")
        if (i != -1){
          var y =str.slice(0, i).toLowerCase()
          if(!ban.contains(y)) res= res :+ str.slice(0, i)
          str = str.slice(i+1, str.length())  
        }
        else {
          res = res :+ str
          str = ""
        }
     }
     res
   }
  
   
}