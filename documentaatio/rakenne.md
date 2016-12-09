##Rakenne
Ohjelma koostuu käyttöliitymästä ja grafiikasta ja ohjelman logiikasta. Käyttöliitymä pitää yllä grafiikka ja yhteyttä ohjelman logiikka.
Ohjelman logiikka koostuu kahdesta osata irrallaan olevasta kartan luonnista (joka kylläkin pitää yhteyttä ruutuihin jotka se luo)
ja pelilogiikasta. Kartan luonti on staatinen ja sen tehtävänä on luoda kartta jota pystyy pelaamaan pelilogiikalla. Pelilogiikka
päivittää ruutuihin pelaajan tekemiä valintoja ja kertoo käyttöliitymälle ja tämän grafiikalle mitä näyttää missäkin. Käyttöliitymä
pitää vain yhteyttä pelilogiikkaan ja päivittää grafiikka. Uutta peliä luotassa käyttö liitymä vain luo uuden pelilogiikan ja 
kartan ja jatkaa näillä pelaamista.
[oliokaavio](https://github.com/teiran/Miinaharavatiera/blob/master/documentaatio/Oliokaavio.jpg)
