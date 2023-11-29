
public class Noeud {
   
    protected Element element;
    protected Noeud fils_Gauche;
    protected Noeud fils_Droite;
  
    

       /**
     * constructeur créant une cellule sans contenu ni suivant
     */

    public Noeud() {
        element = null;
        fils_Gauche= fils_Droite = null;
        
    }

    /**
     * constructeur créant une cellule encapsulant l'objet _contenu 
     * @param _contenu l'objet à encapsuler
     */
    public Noeud(int _cle, double _c) {
        element = new Element(_cle, _c);
        fils_Gauche = fils_Droite = null;
      
    }
public Noeud(Element element){
    this.element=element;
fils_Gauche = null;
    fils_Droite= null;
}

    /**
     * acceseur de la cellule suivante
     * @return suivant
     */
    public Noeud getFilsGauche() {
        return fils_Gauche;
    }
    public Noeud getFilsDroite(){
        return fils_Droite;
    }


    /**
     * modificateur du suivant
     * @param _c la nouvelle cellule suivante
     */
    public void setFilsGauche(Noeud _c) {
        fils_Gauche = _c;
    }
    public void setFilsDroite(Noeud _c){
        fils_Droite = _c;
    }
    
    /**
     * accesseur du contenu
     * @return contenu
     */
    public Element getElement() {
        return element;
    }

    /**
     * modificateur du contenu
     * @param _c le nouveau contenu
     */
    public void setElement(Element _c) {
        element = _c;
    }

    /**
     * repésentation du noeud en chaîne de caractères
     */
    public String toString() {
        if (element == null) {
            return "nil";
        }
        else {
            return element.toString();
        }
    }
    
    public static void main (String args[]){
        Noeud n = new Noeud();
        System.out.println(n);
    }

}
