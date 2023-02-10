# <div align="center"> Warehouse Management System

<div align="center"> This is an educational project in the course IDATA1001 Programming 1 at NTNU. </div>

<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#sammendrag">Sammendrag</a>
      <a href="#terminologi">Terminologi</a>
      <a href="#innledning-problemstilling">Innledning - Problemstilling</a>
      <ul>
        <li><a href="#bakrunn">Bakrunn</a></li>
        <li><a href="#formål-og-problemstilling">Formål og problemstilling</a></li>
        <li><a href="#avgrensninger">Avgrensninger</a></li>
        <li><a href="#begreper/ordsliste">Begreper/Ordsliste</a></li>
        <li><a href="#rapportens oppbygging">Rapportens oppbygging</a></li>
      </ul>
    </li>
    <li>
      <a href="#bakrunn-teorietisk-grunnlag">Bakrunn - Teoretisk Grunnlag</a>
      <a href="#metode---design">Metode - Design</a>
      <a href="#resultater">Resultater</a>
      <a href="#drøfting">Drøfting</a>
      <a href="#konklusjon---erfaring">Konklusjon - Erfaring</a>
      <a href="#referanser">Referanser</a>
      <a href="#vedlegg">Vedlegg</a>
    </li>
  </ol>
</details>

## Sammendrag

Denne rapporten dokumenterer arbeidet med "Warehouse Management System" - prosjektet for IDATA1001-programmering 1-emnet. Målet med applikasjonen er å opprette en programvareløsning for administrasjon og håndtering av et varelager. Det ferdige produktet vil bestå av en tekstbasert brukergrensesnitt som gir en oversikt over varene i registeret og inkluderer de nødvendige funksjonene for å oppfylle kravene.

Kravene for applikasjonen ble publisert av emneforeleseren, så funksjonaliteten er hovedsakelig basert på disse kravene. Noen tilleggsfunksjoner ble valgt fra kandidaten.

Rapporten vil diskutere problemet applikasjonen skal løse, utviklingsprosessen, den underliggende teorien og designstrategien, samt resultatene og refleksjonen fra kandidaten.

## Terminologi

## Innledning - Problemstilling

### *Bakrunn/Formål og problemstilling*

Selskapet Smart House As leverer til bygge bransjen og trenger en programvareløsning for å administrere og organisere sitt lager på en brukervennlig måte. Systemet vil inkludere et vareregister for å lagre de ulike enhetene eller produktene, og et tekstbasert brukergrensesnitt for brukeren å interagere med vareregisteret Selskapet ber om utvikling av en applikasjon for å gi brukerne grunnleggende funksjonalitet for administrasjon og håndtering av daglige operasjoner i et lager. «Usecase» diagrammet viser de ulike funksjonene som trengs i applikasjonen og illustrerer interaksjon mellom brukere og brukergrensesnitt, samt prosessen som utløses av brukerens intensjoner. Prosjektet ble utviklet i løpet av høsten 2022, med prosessen delt inn i tre spesifikke iterasjoner gjennom semesteret. Det ferdige produktet må oppfylle kravene og fungere som vist i diagrammet, samt inkludere en rapport av prosjektet.

![image](https://user-images.githubusercontent.com/99481282/218208186-20850bbc-34c4-4bf6-8b53-21f86fc6ef9b.png)

Definering av problemstilling: «Det skal utvikles en programvare som skal brukes av et varehus – Smarthus As. Programvaren skal brukes til å håndtere varelageret Smarthus AS (såkalt «Warehouse management system (WMS) på engelsk). Smarthus AS leverer hovedsakelig varer til bygg-industrien, så typiske varer er laminatgulv, dører og vinduer, lister og annet trevirke. Løsningen skal til slutt bestå av et tekstbasert brukergrensesnitt og et register som lagrer informasjon. Løsningen skal utvikles igjennom 3 iterasjoner: Del 1, 2, og 3. I tillegg til selve programmet, skal du også skrive rapport.»

I tillegg til å løse problemet, må dette prosjektet også oppfylle følgende kriterier:
• Koden vil bli verifisert av CheckStyle-plugin og ikke ha noen advarsler.
• Alle metodene, variablene, konstruktørene og klassene må ha gode definerte navn og skrive på engelsk.
• Programmet må kunne håndtere feil inndata fra brukeren og ha et brukervennlig grensesnitt.

### Avgrensninger

### Begreper/Ordliste

| Begrep (norsk)         | Begrep (Engelsk)             | Betyding/beskrivelse |
| :---                   |     :---:                    |          :---: |
| algoritme              | Algorithm                    | Algoritme er en sekvens av instruksjoner som løser ett spesifikt problem. |
| Kjøreitd               | Runtime                      | Kjøretid er effektiviteten til et program hvor det er som mål å utføre antall operasjoner som må gjøress for                                                           å løse en gitt størrelse. |
| OOP                    | OOP                          | Objektorientert programmering er et paradigme for programmering av datamaskiner.    |
| HashMap                |HashMap                       | HashMap i Java er en samling basert på Map og består av nøkkelverdipar. |
| ArrayList              | ArrayList                    | En java Arraylist er en generell liste, som kan skalere størrelsen sin.    |
| Kobling                |Coupling                      | Kobling er et designprisnipp om koblingen mellom enheter.      |
| Innkapsling            | Encapsulation                | Innkapsling er en programmeringsteknikk som har som formål å hindre direkte tilgang til tilstanden til et                                                               bjekt fra objekter av andre klasser.    |
| Abstraksjon            | Abstraction                  | Abstraksjon vil si å skjule kompleksitet og trekke ut det overordnede og viktigeste.      |
| Arv                    | Heritage                     | Arv er en mekanisme for å bygge videree på eksisterende klasser.    |
| Kohesjon               | Cohesion                     | Et design prinsipp som handler om antallet av oppgaver som en enhet i et program klarer å håndtere.   |
| Ansvarsdrevet design   | Repsonibility driven design  | Ansvarsområder for de forskjellige enhetene i et program som burde være tydelig.  |
| Rekursjon              |Recursion                     | Rekursjon er noe som kaller på seg selv.              |
| Minneforbruk           |Memory consumption            | Minne forbruk er mengden av RAM som er i bruk.  |
| Datastruktur           |  Data structure              | Er en måte og organisere data på i en datamaskin.   |
| Feilsøking             | Debugging                    | Used for checking the programs functionalityand test it.     |

### Rapportens Oppbygging

Hovedinnholdet i rapporten kan deles inn i to hoveddeler:

• Teori og metodikk
• Resultater og diskusjon

Den første delen vil dekke den underliggende teorien og designprinsippene for løsningen, inkludert en diskusjon av objektorientert programmering og algoritmer. Den andre delen vil presentere det ferdige produktet av programvaren, inkludert en vurdering av dets robusthet og potensial for fremtidig utvikling. Kandidaten vil deretter reflektere over sitt arbeid og erfaringer gjennom hele prosjektet, som vil bli inkludert i rapportens konklusjon.

## Bakgrunn

Objekt-orientert programmering (OOP) er en form for dataprogrammering som ser på
verden som et sett med objekter som kan modelleres og representere ved hjelp av
spesifikke objekter eller klasser. En klasse definerer en datatype og beskriver innhold og
egenskaper til objekter av denne datatypen. Klassens datafelter en lagringsenhet for
objektets verdier, og klassens metoder beskriver operasjonene som kan gjøres på eller
av objektene.

OOP har flere viktige prinsipper, inkludert gjenbruk av kode, abstraksjon, innkapsling,
aksesskontroll, arv og polymorfisme. Gjenbruk av kode er et viktig prinsipp i
objektorientert programmering, hvor en datatype først er definert i form av en
klassedefinisjon, kan den gjenbrukes i nye dataprogrammer. Dette her har ført til
utvikling av mange rammeverk og biblioteker som inneholder ferdig programvare som
programmerere kan gjenbruke og bygge videre på. Aksesskontroll er når det ulike
objektene i et program skal kommunisere med hverandre, er det viktig at objektets
integritet bevares, det vil si at dataene som blir lagret i objektet ikke blir forandret eller
ødelagt på en uønsket måte av andre deler av programmet. Arv og polyforisme er hvor
ting blir kategorisert hierarkisk, for eksempel en bok er en fellesbetegnelse for alle bøker.
Abstraksjon går ut på å gjøre programmereren underveis kan ignorere noen av detaljene
ved implementasjon av det som jobbes med. Innkapsling går ut på å skjule den interne
tilstanden til et objekt fra andre. Dette fører til at utenforstående kode ikke kan endre på
tilstanden til et objekt på uforutsette måter.


For å sikre at det utviklede programvaren er stabilt, fleksibelt og godt strukturert, finnes
det prinsipper for objektorientert design som har som mål å bevare disse egenskapene.
De viktigste av disse designprinsippene er kobling, samhørighet og ansvarsdrevet design.

Prinsippene innenfor kobling er måling av hvor sterkt et objekt er knyttet til andre
objekter innen OOP. Det innen kobling ønsket at objekter har et begrenset antall
avhengigheter. Om man har lav kobling henger det ofte sammen med høy kohesjon noe
som er ofte ønsket. Kohesjon handler om hvor mye ansvar de ulike enhetene i et
program har. Hvis for eksempel en enhet har ansvar for en enkel oppgave, blir dette
relatert med høg kohesjon.

Innen kobling finnes det også et prinsipp som heter ansvarsdrevet design. Dette går ut
på at programmets struktur hver klasse må ha ansvar for å manipulere og håndtere sine
egne data. Metoder og løsninger for delproblemer bør være en del av klassen som gir
funksjonalitet for de enhetene – for eksempel bør endringer i et klasseobjekts data
utføres innen objektet selv, i stedet for i en ekstern klasse.

Med prinsippene for OOP, så er det flere fundamentale regler for programmering som
også må bli tatt i betraktning når man skal utvikle en programvare. OOP gir gode
perspektiver på hvordan man skal strukturere og tolke et problem, men programmet må
inneholde kode som skal løse det faktiske problemet. Denne løsningen må være korrekt
og effektiv i forhold til kjøretid og minneforbruk.

Her kan vi dra in noe som heter algoritme, som er en rekke instruksjoner for å løse et
problem. Algoritmer er sett på som en kodeblokk som kan gi en unik løsning på et
spesifikt problem og gi korrekt verdi når den terminerer. Det er tre ting som skal være
med en algoritme som gjør at den kan anses som god, og dem er effektivitet, at den
terminerer og at den terminerer med korrekt verdi.

Når det kommer til å søke etter en bestemt verdi i en list med en stor samling av data
kan være tidskrevende og bruke mye minne, spesielt hvis det gjøres av en algoritme
med dårlige egenskaper. For at søket skal bli utført raskt, så er det viktig å analysere
problemet nøye og gjøre det riktige tiltakene for å fikse dette. Et eksempel kan være å
hvis du skal søke igjennom en liste etter en spesifikk verdi, der man iterer igjennom
listen med linær søking så gir dette en kjøretid på O (n). Denne kjøretiden er dårlig i
forhold til andre metoder i tilfellene hvor man har store lister som føre til dårlig kjøretid
og mye bruk av minne. Men ved bruk av en annen datastruktur som heter HashMap vil
kjøretiden være O (1), noe som er mye mer effektiv ettersom det vil ta konstant antall
operasjoner for å finne en eksakt verdi, uavhengig av størrelsen på HashMap-en.
Årsaken til dette er på grunn av at HashMap bruker en unik nøkkel for hver verdi som blir
lagret og bruker en hash-funksjon for å tildele verdiene en minneposisjon.

For å tilpasse programvaren for et gitt problem, er det viktig å analysere problemet ved
hjelp av Objektorientert programmering (OOP) prinsipper. For dette prosjektet kan vi
anta at følgende klasser vil være nødvendig:

• Vare: Denne klassen vil representere en spesifikk vare i Smarthus As
applikasjonen. Siden lageret sannsynligvis vil inneholde mange forskjellige typer
varer, tillater denne klassen oss å opprette flere varianter av varer uten å måtte
definere hver enkelt individuelt.

• Registrering: Denne klassen vil representere lageret. Lageret bør kunne lagre og
organisere instanser av vareklassen, slik at de kan hentes og brukes enkelt. Det
bør også etterligne oppførselen til et fysisk lager.

• Applikasjon: Denne klassen vil fungere som en fasade og tilby et brukervennlig
grensesnitt mellom brukeren og registeret. Det bør tilby nødvendig funksjonalitet
og kommunisere tydelig eventuelle resultater til brukeren.

Arkitekturen er blitt delt inn i tre hoveddeler, der hver del har sine ansvarsområder. Det
fører til at lenken mellom disse klassene er løs og er godt definert, noe som fører til ett
godt utgangspunkt i programmet.

## Metode - Design

For utviklingen av selve prosjektet har kandidaten tatt i bruk IntelliJ og CheckStyleplugin.

Item klassen representerer en vare i lageret. Som visualisert i livsløps-diagremmet til høyre, så kan notere seg at alle feltene i denne klassen er satt som private. Årsaken til dette er at dette er med på å styrke innkapslingprinsippet og fremmer løs kobling, noe som ble nevnt i teori delen som var noen av dem viktige prinsippene i OOP. For å kunne gjøre endringer eller få tilgang til et Item-objekt, så må det gjøres igjennom en aksessor- og mutator metoder, dette er for å sikre at ugyldige verdier blir håndtert. For å oppnå dette har kandidaten opprettet konstruktøren checkField() – hvor alle feltene for attributtene blir sjekket, og skulle det hende at det kom en ugyldig ferdig blir det kastet exception. Dette bidrar til å unngå unødvendige feilaktige data i systemet og er med på å øke integriteten til dataene i Item klassen.

![image](https://user-images.githubusercontent.com/99481282/218213337-4d0eea18-5338-4575-9f24-cf9514b2bba0.png)


ItemRegister-klasse er ansvarlig for lagre instanser av Item-klassen og vil representere
som et lager. Klassen består av et felt «items», hvor items variabelen items er av
datatypen HashMao og brukes for å lagre instanser av item-klassen. Kandidaten har tatt
for seg å iverksette HashMap istedenfor ArrayList på grunn av kjøretid, effektivitet og
håndtering av store mengder data. Som tidlegere nevnt i teori delen, så vil HashMap ha
enda raskere kjøretid og minneforbruk enn ArrayList. Ettersom hvis det er ønsket å
iterere igjennom en liste så ville ArrayList brukt O (n), også ville HashMap en kjøretid på
O (1). Dette forklarer at HashMap gir kandidaten mulighet til å lett få tak i elementer i
lister ved bruk av den assosierte nøkkelen.

UserInterface – klassen representerer applikasjonen for Smarthus As. Et objekt av denne
klassen er ansvarlig for å starte applikasjonen og være brukergrensesnittet (UI) for
applikasjonen. Klassen har blitt strukturert i form av underoppgaver som skal utføres.
Derfor har følgende metoder blitt implementert: init (), som er ansvarlig for å initialere
app-objektet ved å opprette en intern instans av Item Register klassen og fylle
vareregisteret med dummy-data for debugging. Start () er startpunktet for
applikasjonsobjektet. Etter at en instans av Item Register klassen er opprettet, blir denne
metoden kaldt. Start metoden vil deretter være ansvarlig for å kjøre appen inntil brukeren bestemmer seg for å avslutte. Klassen er robust fordi den har blitt strukturert i form av underoppgaver og har klare ansvarsområder. Løs kobling blir oppnådd ved at klassen ikke er avhengig av andre klasser. Ettersom det ble laget flere meny lag for brukergrensesnittet, så ble det refaktorisert med å liste alle funksjonene med engang, dette var for å minske minneforbruket til applikasjonen og risikoen for «Stack Overflow».

## Resultater

Prosjektet løsning består av en godt forklarede javadoc, med ingen CheckStyle-warnings,
ingen bugs ettersom kandidaten har testet debugging med dummy data.

Utviklingsprosessen til Item klassen var ikke så mye forandringer på, men det ble gjort
en endring som førte til at koden ble mye ryddigere og viser til god kode struktur.
Endringen som ble gjort var i alle set metoder, så ble alle if setninger og exception
fjernet for definering av variabler, og byttet ut med en konstruktør som kunne
representere dem alle in en case funksjon, som deretter kaster en exception hvis det
skulle bli implementert en ugyldig verdi.

For klassen itemRegister ble det brukt HashMap for å håndtere samlingene av
elementene. Årsaken til dette var på grunn av kandidaten antar at brukerene er opptatt
av raske funksjonerer, og dette er noe HashMap kan tilby hvor kjøretiden til HashMap er i
O (1), der den bruker konstant tid til å hente ut et element i listen. Kandidaten hadde
aldri tanken på å bruke ArrayList ettersom kjøretiden for ArrayList er O (n), noe som vil
føre til dårlig kjøretid og mye minneforbruk ettersom listen blir større.

I utviklingsprosessen i UserInterface var løsning nummer en å flere lag av menyer, men
ettersom dette kunne trigge «call stack-en», som igjen kan føre til «Stack Overflow».
Men med litt analysering av brukervennlighet og kode prinsipper, så ble løsning nummer
erstattet med løsning nummer 2, som var å skrive ut alle det ulike metodene rett ut på
brukergrensesnittet. Årsaken til at kandidaten mener det er mer funksjonelt er på grunn
av det gir brukeren en bedre oversikt over hvilke funksjoner som er tilgjengelig og samt
ikke trigger «Call-stacken». Dette fører til at det ikke blir så høy rekursjon og man
uteligger risikoen for overflow, noe som fører til at programmet er mer robust og
funksjonelt.

En annen endring i UserInterface klassen er validate konstruktører for både nummer
(Integer, Double) og text (String), hvor den definerer verdiene for de ulike verdiene
brukerene setter. Denne endringen gjorde store endringer for applikasjonen når det
kommer til robusthet i det ulike funksjonene. Den gjør det mulig for brukergrensesnittet
å håndtere ugyldige data, sik at brukergrensesnittet veileder bruker hvor den forklarer
situasjonen og sier hva brukeren må gjøre for å ordne opp i det. Dette gjør applikasjonen
mye mer robust, som igjen fører til god brukervennlighet.

Løsningen av prosjektet er godt dokumentert med javadoc og i fullt henhold til
CheckStyle plugin. Årsakene til dette er for å skape en god struktur på koden og for at
kandidaten som utvikler programvaren skal kunne gjenkjenne alle ulike aspekter av
koden.

En del ut av metodene for at programmet skulle oppnå robusthet var å implementere
dummy data, for å kunne visualisere og teste funksjonene. Denne dummy dataen var for å debugge programmet og bli kvitt bugs, slik at interaksjonen mellom
brukergrensesnittet og brukeren blir best mulig, dette styrker robustheten til løsningen.
Det er også gjort JUnit tester for klassene Item og Item Register. Det er for å sjekke at
dem mutator- og aksessor metodene funker som dem skal i henhold til koden, mens i
ItemRegister blir funksjonaliteten for de ulike metodene testet, og om dem gir ut riktig
verdi. Både debuggingen og testing styrker selvtilliten til teorien bak om at programmet
er blitt veldig robust, men man skal ha i baktanke at et uendelig mulige bugs som kan
forekomme, så man kan bare styrke teorien sin bak testingen og aldri si at programmet
er 100% fri fra bugs. Her er ikke JUnit testklassene helt ferdig ettersom kandidaten
kunne laget flere tester, men ettersom det er gjort noen JUnit tester og gjort en del
debugging, så mener kandidaten det at programmet er ganske robust ut ifra
debuggingen primært.

For oppsumering er løsningen for prosjektet bestående av ett robust, løs kobling, høg
kohesjon, og inkludert gode designprinsipper i programmet.

## Drøfting

Det ferdigstilte prosjektet inneholder god kode kvalitet, der prinsippene som god
dokumentasjon, løs kobling, høg cohesion og robusthet er implementert i programmet
ifølge kandidaten. Prosjektet er et godt resultat av den gitte problemstillingen, der
ferdigstilling av prosjektet gav ingen utslag fra CheckStyle-plugin.

Kandidaten evaluerer kildene som er brukt i henhold til rapporten og koding av
prosjektet som kode kilder, ettersom det er pensum bøker som blir anbefalt fra NTNU.
Metoden add item i UserInterface klassen mener kandidaten er ganske robust, men
kanskje kunne refraktorers litt med tanke på mengden kodelinjer og antall «do»
statements, men kandidaten ser på dette som fremtidig arbeid.

Brukergrensesnittet er oversiktlig og veldig lett og bruker ettersom alle metodene er
listet nedenfor. De ulike meny funksjonene er godt forklart og er fungerende i henhold til
krav spesifikasjonene, der kandidaten ikke har avslørt noen bugs som får programmet til
å krasje. Koden er også testet i JUnit-klasser noe som bygger på selvtilliten for selve
programmet. Kandidaten har god tro på at Smarthus As vil være fornøyd med løsning
som er blitt gjort, og at programmet dekker de ønskede kravspesifikasjonen, samt
problemstillingen. Programmet består av robust kode, god kodestil og i henhold til gode
designprinsipper. 

## Konklusjon

Prosjektet har vært lærerikt og kandidateten har støtt på ulike utfordringer som har gitt
god lærdom. Av alle utfordringene var det utviklingen av brukergrensesnittet som var
vanskeligst, der kandidaten gikk ifra å ha mye rekursiv kode til å endre hele
brukergrensesnittet ned til å ha alle funksjonene på første grensesnitt laget. Den første
metoden ble sett på som litt for komplisert og unødvendig, der kandidaten mener siste
løsning er den mest gunstige for programmet.

Er det noe kandidaten mener han burde gjort annerledes er det å ha iverksatt
versjonskontroll på GitHub mye tidligere i prosjektet. Dette kunne bidratt til å skape ett
mye bedre oversikt over daglige, ukentlig, månedlige mål og fungert som en reserve
bruker i tilfelle datamaskinen skulle krasjet.

Dersom kandidaten skulle tatt opp fremtidige løsninger og arbeid for denne
applikasjonen, hadde det vært og iverksatt ulike prosedyrer innen utvikling for
brukergrensesnittet slik at det hadde faktisk vært ett skikkelig brukergrensesnitt og ikke
utskrift i terminalen.

Til slutt, så er kandidaten fornøyd med løsningen som er blitt laget til Smarthus As, og
mener at dette programmet er en god løsning i henhold til krav spesifikasjonene og
problemstillingen. Løsningen som er gitt burde dekke disse kravene gitt ut fra bedriften
og faglæreren.

## Referanse

[1] “Data Structures & Algorithms in Java”, Sixth edition, av Michael T. Goodrich. ISBN: 978-1-118-80857-3

[2] “Objects First with Java”, Barnes Kolling. ISBN: 1-292-15904-9

## Vedlegg

Vedleggene i rapporten er laget i figma.



