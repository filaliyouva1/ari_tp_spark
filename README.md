# Première partie du TP : la prise en main simple du framework

Dans cette première partie nous allons mettre en pratique les mécanismes simples vus en cours juste avant.

#### Documentation utiles

- [Documentation officielle](https://duckduckgo.com)
- [Baeldung](https://www.baeldung.com/spark-framework-rest-api)

## 1. écriture des requêtes

Pour cette première partie tout se passer dans la classe **miage.ari.sparktp.Introduction.WebConfig** à l'intérieur de la méthode "*setupRoutes*". Vous retrouverez un exemple de get simple.

##### 1.1.1 GET avec et sans paramètre

Prenons l'exemple qui vous servait à vérifier que votre machine était bien configurée, on retrouve simplement un appel de méthode statique *get* avec deux paramètres, en premier la route et en second le retour de l'appel, ici une méthode prenant en entrée la requête et la réponse et renvoyant une chaine de caractère.

*get(route, callback)*

```sh
 get("config", (req, res) -> "Vous avez bien configuré votre poste pour le tp Spark");
```

A vous de mettre en pratique maintenant, vous allez commencer par faire votre propre route qui avec un paramètre, ici un nom, renverra à l'appel *Bienvenue [VOTRE NOM]*.

```sh
 /hello/JohnDoe -> Bienvenue John Doe
```

A vous de jouer, n'hésitez pas à fouiller la doc.

##### 1.1.2 La redirection de requête

Il va falloir maintenant faire une redirection, ecrivez une route qui lorsqu'on l'appelle redirige vers la route "*redirected*"

```sh
 /doRedirect -> /redirected
```

**La route redirected est donné dans le tp !**

##### 1.1.3 GET avec plusieurs parametres

Apres ça vous pouvez mettre en place une route avec un get avec deux parametres, petite indication utilisé la fonction splat() pour récuperer un tableau de parametres

```sh
 hello/*/*
```

##### 1.1.4 Une étape avant la requête

Il vous faudra ajouter une étape avant la route **hello2/:username**, cette étape viendra vérifer que le username passé en paramètre n'est pas égal à "interdit" si c'est le cas l'utilisateur sera redirigé vers une erreur 500 avec un message disant que cet utilisateur est interdit. Je vous invite a regarder du côté du *before* et du *halt* dans la documentation.

##### 1.1.5 Jouer avec les sessions

Prochaine étape il vous faudra faire une requête qui utilisera le principe de session pour passer des attributs. Vous avez une route qui est déjà définie **redirectedWithAttributes**, vous devrez écrire une route qui redirige vers cette route (redirectedWithAttributes) avec une session qui a pour attribut "toto" de valeur "tata". Vous pouvez vous aider du chapitre lié au session dans la doc.

#### 1.2 A vous de jouer

##### 1.2.1 Un route qui renvoit des opérations

Vous devez écrire une route sous la forme :

```sh
 {nombre1}/{operateur}/{nombre2}
```

qui renvoit le résultat de l'opération : nombre1{operateur}nombre2.
Exemple : 

```sh
1/plus/2 => 1+2 => 3
```

##### 1.2.2 On teste le after

On peut retrouver dans votre classe WebConfig deux routes "testAfter" et "testAfterOk". Avec le framework on a la possibilité d'exécuter des actions après un appel (regardez dans la doc au sujet du **after**). Implémenter le after pour rediriger vers "testAfterOk".

## 2. MiniTwit 