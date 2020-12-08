package miage.ari.sparktp.Introduction.configurationmachine;

import static spark.Spark.get;
import static spark.Spark.halt;

public class WebConfig {

    public WebConfig() {
        this.setupRoutes();
    }

    private void setupRoutes() {
        get("config", (req, res) -> "Vous avez bien configuré votre poste pour le tp Spark");

        //TODO bloc ci-dessous (ecriture de requete simple)
        /*
        A la manière du get ci-dessus ecrivez d'abord une methode get /hello/[votreNom] qui renvoit Bonjour [votreNom]
        vous pouvez vous aider du support de cours (n'oubliez pas de chercher du cote du parametre req ;) )
         */

        /*
        Ensuite il vous faudra faire une redirection, choisissez l'adresse que vous voulez, l'essentiel et que cette
        adresse redirige vers l'url "redirected" donne plus bas, vous pouvez vous appuyez du cours ou encore une fois
        de la documentation
         */

        /*
        Ensuite vous pouvez vous voir dans la partie 1.1.3 du TP que vous devez écrire une requête avec plusieurs paramètres
         */

        /*
        On monte en complexité avec le hello2, vous avez la requête hello2 qui est ecrite vous devrez vous servir du
        before pour faire des actions avant l'exécution de cette route (voir la doc).
        Vous devrez vérifier que le paramètre n'est pas égal à "interdit", si c'est le cas servez vous du "halt" pour
        renvoyer une erreur et lui interdire l'accès
         */

        /*
        Un peu comme le redirect mais en plus dur cette fois vous allez écrire une route qui renvoit vers la route
        "redirectedWithAttributes", attention si cette redirection ne contient pas un attribut toto avec la valeur tata
        vous aurez droit à une erreur (regardez du côté des sessions).
         */


        get("redirected", (req, res) -> "Bien redirigé");

        /**
         * Exemple avec le before
         */
        get("hello2/:username", (req, res) -> {
            return "Le nom" + req.params(":username") + " est valide";
        });


        /**
         * Route donné pour tester la redirection avec attribut en session
         */
        get("redirectedWithAttributes", (req, res) -> {
            if (req.session() == null)
                halt(500, "pas de session");
            if (req.session().attribute("toto") == null || !req.session().attribute("toto").equals("tata"))
                halt(500, "mauvais argument ! ");
            return "Bien joué ce sont les bons arguments";
        });

        /**
         * 1.2.2
         */
        get("testAfter", (res, req) ->{
            return null;
        });

        /*
        TODO Ici implémentez le after
         */

        /**
         * Route qui vérifie que le after a bien été implémenté
         */
        get("testAfterOk", (res, req) -> {
            return "afterOk";
        });
    }
}
