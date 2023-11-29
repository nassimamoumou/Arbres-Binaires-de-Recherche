import java.util.Random;

public class ArbreBinaire {
    private Noeud racine;
    private int hauteurMax = 0;

    public ArbreBinaire() {
        racine = null;
    }


public Noeud getRacine(){
    return racine;
}

public boolean estVide(){
    return racine == null;
}

/**
 * Recherche récursive d'un noeud à partir de sa clé
 * cle la clé de l'élément à rechercher
 *  noeud le noeud courant à partir duquel effectuer la recherche
 * return le noeud correspondant à la clé si elle est trouvée, sinon null
 */
public Noeud recherche(int cle, Noeud noeud) {
    if (noeud == null || noeud.getElement() == null) {
        // cas d'arrêt de la recherche : on a atteint une feuille ou un noeud vide
        return null;
    } else if (cle == noeud.getElement().getCle()) {
        // cas où la clé recherchée est égale à la clé du noeud courant
        return noeud;
    } else if (cle < noeud.getElement().getCle()) {
        // la clé recherchée est inférieure à la clé du noeud courant, on recherche dans le fils gauche
        return recherche(cle, noeud.getFilsGauche());
    } else {
        // la clé recherchée est supérieure à la clé du noeud courant, on recherche dans le fils droit
        return recherche(cle, noeud.getFilsDroite());
    }
}
public boolean ajout(Element n) {
    // Si la racine est null, on insère le nouvel élément en tant que racine
    if (this.racine == null) {
        this.racine = new Noeud(n);
        return true;
    }

    // Si la clé est déjà présente, on arrête l'insertion
    if (this.racine.getElement().getCle() == n.getCle()) {
        return false;
    }

    // Sinon, on descend dans l'arbre en utilisant une méthode récursive
    return ajouterElement(this.racine, n);
}

private boolean ajouterElement(Noeud courant, Element n) {
    // Si la clé est déjà présente, on arrête l'insertion
    if (courant.getElement().getCle() == n.getCle()) {
        return false;
    }

    // Si la clé est inférieure à celle du noeud courant, on insère à gauche
    if (n.getCle() < courant.getElement().getCle()) {
        if (courant.getFilsGauche() == null) {
            courant.setFilsGauche(new Noeud(n));
            return true;
        } else {
            return ajouterElement(courant.getFilsGauche(), n);
        }
    }
    // Sinon, on insère à droite
    else {
        if (courant.getFilsDroite() == null) {
            courant.setFilsDroite(new Noeud(n));
            return true;
        } else {
            return ajouterElement(courant.getFilsDroite(), n);
        }
    }
}




public void afficheInfixeEtHauteur() {
    afficheInfixeEtHauteur(racine, 0);
    System.out.println("Hauteur de l'arbre : " + hauteur(racine));
}

private void afficheInfixeEtHauteur(Noeud n, int profondeur) {
    if (n == null) {
        return;
    }
    afficheInfixeEtHauteur(n.getFilsGauche(), profondeur + 1);
    System.out.println(n.getElement() + " (profondeur : " + profondeur + ")");
    afficheInfixeEtHauteur(n.getFilsDroite(), profondeur + 1);
}

/**
 * Cette méthode calcule récursivement la hauteur de chaque sous-arbre en comptant le nombre de niveaux, puis renvoie le maximum entre les hauteurs des sous-arbres gauche et droit, auquel on ajoute 1 pour tenir compte du niveau de la racine.
 */
private int hauteur(Noeud n) {
    if (n == null) {
        return 0;
    } else {
        int hauteurGauche = hauteur(n.getFilsGauche());
        int hauteurDroite = hauteur(n.getFilsDroite());
        return 1 + Math.max(hauteurGauche, hauteurDroite);
    }
}


private Noeud getNoeudMin(Noeud n) {
        Noeud courant = n;
        while (courant.getFilsGauche() != null) {
            courant = courant.getFilsGauche();
        }
        return courant;
    }


public void supprimer(Element e) {
    racine = suppressionRecursive(racine, e);
}

private Noeud suppressionRecursive(Noeud n, Element e) {
    if (n == null) {
        return null;
    }
    if (e.getCle() < n.getElement().getCle()) {
        n.setFilsGauche(suppressionRecursive(n.getFilsGauche(), e));
    } else if (e.getCle() > n.getElement().getCle()) {
        n.setFilsDroite(suppressionRecursive(n.getFilsDroite(), e));
    } else {
        if (n.getFilsGauche() == null) {
            return n.getFilsDroite();
        } else if (n.getFilsDroite() == null) {
            return n.getFilsGauche();
        }
        Noeud successeur = getNoeudMin(n.getFilsDroite());
        n.setElement(successeur.getElement());
        n.setFilsDroite(suppressionRecursive(n.getFilsDroite(), successeur.getElement()));
    }
    return n;
}



}
