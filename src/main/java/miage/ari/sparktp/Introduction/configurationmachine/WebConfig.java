package miage.ari.sparktp.Introduction.configurationmachine;

import static spark.Spark.get;

public class WebConfig {

    public WebConfig(){
        this.setupRoutes();
    }

    private void setupRoutes(){
        get("config", (req, res) -> "Vous avez bien configuré votre poste pour le tp Spark");
    }
}
