import java.lang.Math;
import java.util.* ;
import java.util.Scanner ;
import java.util.Random ;
import java.util.ArrayList;


public class ListeChainee{

   private Cellule tete ;
   private Cellule queue ;



      public ListeChainee(){
        tete = null;
        queue = null ;

    }


      public ListeChainee( Cellule _tete){
        tete = _tete ;

        Cellule temp= tete ;
        if(temp != null){
            while(temp.getSuivant() != null){
                temp=temp.getSuivant() ;
            }
            queue = temp ;
        }
    }

    //methodes

    public boolean estVide(){
        return ( tete == null) ;
    }

    public Cellule getTete(){
        return tete ;
    }

    public Cellule getQueue(){
        return queue ;
    }
// methode ajoute tete qui prends en consideration les doublons
    public void ajouteTete(Object o_tete) {
      // Vérifie si la liste est vide
      if (estVide()) {
          // Si la liste est vide, ajoute simplement l'élément en tête
          tete = new Cellule(o_tete);
          queue = tete;
      } else {
          // Vérifie si l'élément à ajouter n'existe pas déjà dans la liste
          Cellule courant = tete;
          while (courant != null) {
              if (courant.getContenu().equals(o_tete)) {
                  // Si l'élément existe déjà, ne fait rien et retourne
                  return;
              }
              courant = courant.getSuivant();
          }
          // Si l'élément n'existe pas, ajoute-le en tête
          Cellule nouv = new Cellule(o_tete);
          nouv.setSuivant(tete);
          tete = nouv;
      }
  }


    public void ajouteQueue(Object o_queue){
     Cellule nouvelle = new Cellule (o_queue) ;

     if(estVide()){
         tete = nouvelle ;
         queue = nouvelle ;
     }
     else {
         queue.setSuivant(nouvelle) ;
         queue = nouvelle ;
     }
    }
// pour recuperer les valeurs de la liste cad la cellule
    public  Object enTete(){
        if (tete==null){
            return null ;
        }
        return getTete().getContenu() ;
    }


    public Object enQueue (){
        if ( queue == null){
            return null ;
        }
        return getQueue().getContenu() ;
    }
    public void retireTete()
    {
      if (tete==queue)
      {
        tete = null  ;
        queue = null ;
      }
      else {
      Cellule anc_t = tete ;
      tete = tete.getSuivant() ;
      anc_t.setSuivant(null) ; // on doit mettre le suivant de l'ancien tete à null  sinon on a recuperer tous le reste
    }
    }

    public void retireQueue()
    {
        if(estVide()){
            tete = null;
            queue = null;
        }
        Cellule c = tete  ;
        while(c.getSuivant()!=queue)  //parcourire a l'avant dernier element
        {
            c = c.getSuivant() ;
        }
        c.setSuivant(null) ; // NILL
        queue = c ;
    }
    public void inserePos(int pos , Element o)
    {
         Cellule nv =new Cellule(o) ;
      Cellule avant = tete ;
         int i =  1 ;
      if (pos<0)
      {
        System.out.println("position non valide") ;
      }
      if (pos==1)
      {
       ajouteTete(o) ;
      }

      else {
      while(i!=pos-1 || avant.getSuivant() !=null)  // position avant l'elts  ;
        {
         avant = avant.getSuivant() ;
          i++ ;
        }
       if (avant.getSuivant()==null)
        {
           ajouteQueue(o) ;
        }

       else {
         nv.setSuivant(avant.getSuivant()) ;//

            avant.setSuivant(nv) ; }
         }
    }

    // methode retirer qui prends en parametre
    public void retirer(Object contenu) {
    if (estVide()) {
        return;
    }
    if (tete.getContenu().equals(contenu)) {
        retireTete();
        return;
    }
    Cellule courante = tete.getSuivant();
    Cellule precedente = tete;
    while (courante != null) {
        if (courante.getContenu().equals(contenu)) {
            precedente.setSuivant(courante.getSuivant());
            if (precedente.getSuivant() == null) {
                queue = precedente;
            }
            return;
        }
        precedente = courante;
        courante = courante.getSuivant();
    }
}
// methode recherche qui retourne un boolean

    public  boolean recherche(int n )
    {
       Cellule courant = tete ;
       boolean existe = false ;
       while(courant.getSuivant()!= null )
       {
        if(n==(int) courant.getContenu())
        {
            existe = true ;
        }
        courant = courant.getSuivant() ;
       }
       return existe ;
    }


// methode qui retire selon la position
public void retirePos(int pos)
{

      if(pos==1)
      {
        retireTete() ;
      }
      else{

      int i = 1 ;
      Cellule avant  = tete  ;

      while(i!=pos-1 && avant.getSuivant() !=null)// la position avant l elts
        {
          avant = avant.getSuivant() ;
          i++ ;
        }
       Cellule asup = avant.getSuivant() ; // l'element à retirer
       if(asup==null)
         {
            System.out.println("pas d'elemnts a suprimer fin de la liste ") ;
         }

       else {
       if (asup.getSuivant() == null ) // si l'element est la queue
        {
        retireQueue() ;
        }
       else{
       avant.setSuivant(asup.getSuivant()) ;
       asup.setSuivant(null) ;
        }
       }
      }
}


    public String toString(){
        if(estVide()){
            return "nil";
        }
        Cellule courante = tete;
        String resu = courante.toString();
        courante = courante.getSuivant();
        while(courante != null){
            resu = resu + " -> " +courante.toString() ;
            courante = courante.getSuivant();
        }
        return resu + "->nil";
    }



public static void main(String[] args) {
  Cellule c = new Cellule(new Element(0,1)) ;
  ListeChainee liste = new ListeChainee(c) ;
  System.out.println("liste " + liste.toString()) ;

}
}
