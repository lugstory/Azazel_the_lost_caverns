# Azazel - the lost caverns

### Název hry: Jak se hra jmenuje?
- Azazel - the lost caverns

### Popis výchozí situace: Kdo je hlavní hrdina? Kde se hra odehrává? Jaký je příběh nebo základní motiv?
- Azazel, zvídavý kluk prozkoumává les, kde najde opuštěnou chatu, uvnitř najde knihu plnou neznámých symbolů a tajemných textů. Jakmile ji otevřel, místnost kolem něj se začne měnit. Nyní začne jeho dlouhý boj, aby zjistil, co tato chata je zač, ale hlavně *musí utéct pryč!*

### Cíl hry: Co je úkolem hráče? Jak hráč pozná, že vyhrál?
- Úkolem hráče je zjistit jak se dostat z těchto prostorů a zjistit jak se tam dostal. Jak a proč ho kniha do těchto prostorů vcucla?

### Postup k vítězství: Jaké kroky musí hráč podniknout, aby dosáhl cíle? (např. sběr předmětů, komunikace s postavami, řešení hádanek)
- Azazel přijde do kontaktu s desítkami příšer a unikátními místnostmi, po zabití příšer v jednotlivých místnostech dostane (či nedostane) odměnu ve formě předmětů, které bude moci využít v boji.

### Prostory/místnosti: Popis jednotlivých míst, kde se bude hra odehrávat, a jak jsou propojené. Vytvořte grafický plánek propojení jednotlivých míst (obrázek/diagram).
![Mapa](https://i.postimg.cc/MHpg5hzq/mapa.png)

### Důležité postavy: Kdo se ve hře vyskytuje? (např. spojenci, nepřátelé, neutrální postavy)
- game obsahuje pouze nepřátele - příšery.

### Předměty a inventář: Jaké předměty lze sbírat? Jaký mají účel?
- Inventář funguje na principu sebrat a nechat - hráč sbírá předměty a ty mu dávají pasivní efekty.
    Dále má hráč k dispozici jeden slot na aktivní předmět, který se nabíjí při dokončení místnosti.

### Herní mechaniky: Jaké herní funkce bude hra obsahovat? (např. možnost použití předmětů, pohyb mezi místnostmi, interakce s postavami)
- Systém zdraví - hrou se dynamicky může měnit maximální počet životů
- Systém boje - těžký způsob boje, který je možno se naučit.
- Využívání aktivních předmětů.
- Pohyb mezi místnostmi pomocí dveří v každé místnosti.

### Seznam příkazů: Jaké příkazy bude hráč moci použít? (např. jdi, vezmi, pouzij, mluv) Jak bude vypadat formát jejich zápisu ve hře. 
1. jdi ``<číslo dveří>``
    - vejde do místnosti
2. aktivuj
    - aktivuje aktivní předmět (pokud je nabitý)
3. seber ``<číslo (id) předmětu>``
    - sebere daný předmět, pokud sebrání předmětu změní cokoliv v místnosti oznámí tuto změnu uživatel (když seberu předmět 1, předmět 2 zmizí)
4. utok ``<číslo (id) nepřítele>``
    - spustí boj s daným nepřítelem
5. klic ``<číslo (id) truhly>``
    - pokud má uživatel alespoň jeden klíč, otevře danou truhlu
6. bomba ``<strana>``
    - pokud má uživatel alespoň jednu bombu, odpálí bombu na dané straně - na mapě se nachází *skryté* a ***ultra*** *skryté* místnosti - bomba je *odhalí*
