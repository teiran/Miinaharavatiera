##toinen viikko
ensinnäkin logiikasta puuttuu enää oikeastaan rekuriivinen tyhjienalueiden läpikäynti tai se on siellä 
mutta ei toimi ja on kesken. 
Testejä on vain 5, niitä ei millään saa 10 (mut se on varmaankin suuntaa antavaa) ja myös se että 
osaasioista vaike testata, tarttee kattoo ensviikolla saisko osaa private metodesta (joita ei kyl luokka kaaviossa)
niin pilkottuu fiksusti. (mielestäni ruutu toimii hyvin, Ruudukon luontia ei ole järkevää jakaa pienempiin osiin 
ja ei myöskään RuudukkoAvattuSuljettu luokkia). Lisäksi monessa kohtaa miinaharava ruudukkoa läpikäytäessä toistuu 
sama rakenne joka näyttää monimutkaiselta mutta tosiasiassa käy vaan ruudun viereiset ruudut läpi huomioiden reuna ruudut.
Oliokaavio on ehkä vähän surkea en löytänyt sopivia nuolia kuvaamaan riipuvuuksia tarttee kattoo ensviikolla. Ehkä tästä
vois tehdä statik metodin mut tartee kattoa. 
Ensiviikolla pitää saada se pieni pala logiikkaa kuntoo ja tehä graafinen käyttöliitymä, mutta ennen kaikkee keskittyy 
testaukseen.

##kolmas viikko
Grafiikka on lähestulkoon valmis, mietin vain että onko hyvän kun linkkasin jButton luokkaan käyttöliitymän ja käyttöliitymään Jbuttonit. Ilman että olisin linkannu jButtoneihin käyttöliitymän niin miten olisin voinut saada jokaisen napin painalluksen kohdalla päivittymään grafiikan, varsinkin kun on kaksi operaatiota jotka muutavat muitakin ruutuja kuin itseään. Ensiviikolla tarttee saada kartan koon muutaminen fiksuksi ja mahdollinen aloitavava graafinen käyttö liitymä.
Logiikassa sain tälläviikolla liput valmiiksi. Edelleen tyhjän aleen avaaminen on ongelma. testejä sain hyvin eteenpäin, rivikaatavuuden 80% ja mutaatiot testauksen 50%. Homma rupeaa olemaan aika valmis tai muutamaa asiaa pitää vielä hioa.

## Neljäsviikko
Grafiikka ja käyttöliitymä toimii, korjasin koodista helpompi lukuista. Vielä tarttee kattoo pelin lopetus, mut aikalailla valmista. Tietenkin muutamaa lisäominaisuus tulee mieleen tarttee kattoo jos vaik tekis ne. Pitin rivi kattavuus joku n.90 pinnaa ja mutaatio kattavuus 80 pinnaa et testaamisessakaan ei ongelmia.

## Viidesviikko 
parantelin koodia, en kerennyt tänään katsoa laajennuksia tulen katsomaan niitä viikonlopunaikana ennen ensviikon pajaa. en saanut tänään muuta eteenpäin kuin selvenssin koodia helpompi lukuisammaksi

## Kuudesviikko
Sain uudenpelin aloittamisen korjattuu. Vieläkin käyttöliitymää tarvitsisi vähän hioa. Lisäksi en saanut mainclass polkua löydettä oikein joten se ei vielä toimi....

## enne palautusta
Peli toimii ja siinä ei ole bugeja, peliin saisi helposti laitettua ajastimen ja highsoren. Tällä viikolla parantelin pääasiassa käyttöliitymän sselkeyttä ja loin uuden ominaisuuden, keskinappulan joka avaa kaikki liputtomat nappulat ruudun vierestä.
