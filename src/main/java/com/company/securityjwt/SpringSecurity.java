package com.company.securityjwt;

public class SpringSecurity {
/*

    //---------------------------------------------------------------------------------------(info)
    //---------------------------------------------------------------------------------------(info)
    //instructor= HuseynAhmadov (sourceLink= https://youtu.be/5Bj1ZEvsTWI)
    //Topic= SpringSecurity (1,2,3,4)




    //DERS1 ---------------------------------------------------------------------------------------
    //Topic= SpringSecurity(1)

    NoteTopics: springSecurityNəÜçnİstfOlnur; lazimliDependencies; authentication-authorization; formBasedAuthentication;
                endpoints; BasicAuthentication; antMatchers();

    //tutorialuHazırlamaSəbəbi
    microService’de outh2 ilə əlaqəli nələrsə varmş o səbəbdən öncə spring security vs haqda öyrənək. MicroService’de o məsələlər həll olunsun.

    //lazimliDependencies;
    security,web (men lombok'da istf edirem)

    //springSecurityNəÜçnİstfOlnur;
    icazələr limitlər vs qoymaq üçn istf edrik. Misal filan səyfəyə hamı girsin, buna mənnən başqa heçkəs girməsin, buna ancaq login olanlar girsin

    //authentication-authorization;
    Authentication and authorization are two vital information security processes that administrators use to protect systems and information.
    Authentication verifies the identity of a user or service, and authorization determines their access rights.
    Lori dildə loginParol ilə daxil olmaq authentication. Hansısa səyfələrə girmə yetkiləri authorization prosesidir.

    //formBasedAuthentication;
    springSecurity’de en temel, en sadə authentication növüdür. spring security'nin default Authentication novudur.
    Form-Based authentication is a way in which user's authentication is done by login form. This form is built-in and provided by spring security framework.
    (https://www.javatpoint.com/spring-security-form-based-authentication)
    /logout =hansi seyfeye girmeye calsisan da birinci login olmagini teleb edecek. (asagida yazmisam username ve password'u). Lakin logout ucun. http://localhost:8080/logout yazmalisan. Sorsacaq ki eminsenmi. bunlar hamisi spring security'iyle beraber gelib.
             session baglanir.

    *endpoint= 7.20. url’ə endpoint dedi. Hansıkı controller’in içndəki get methodunun url’si idi.
    *username= "user", password= runEdendeConsole'da yazir (her rerun tdikde bu password deysecek)

    *error: mende acilmirdi localhost. eslinde elle adresi(endpointimizi) yazmaliyammis. http://localhost:8080/api/v1/students/2
            belelikle eyni result'i aldim. security ise dusdu. ve qarsima formBasedAuthentication cixardi
    *error: Unchecked runtime.lastError: The message port closed before a response was received.
            cozdum= I disabled all installed extensions in Chrome
    *error: Whitelabel Error Page This application has no explicit mapping for /error, so you are seeing this as a fallback.
            Bunun olmasinin yaygin sebebi basqadir. Lakin men @GetMapping strukturunda sef etmisdim.
            @GetMapping("/{studentId}")
            public Student getStudent(@PathVariable Integer studentId){}
            Burda dirnaqlar arasindaki ile @PathVariable olraq isarelenen eyni olmalidir. hal hazirda eynidir lakin men id ve studentId etmisdim. yeni ferqli idiler
            Plus dirnaqdan sonra kvadrat moterize acilmalidir. Lakin men onuda acmamisdim. (cunki bu url deil. url olsaydi moterze ehtiyac qalmazdi. lakin url'de o hisseye reqem yazlacaq "studentId" yazilmiyacaq)


    //BasicAuthentication;
    ferqli nov Authentication olma yollari var. misal basic, oauth, oauth2, digest...
    BasicAuthentication= In the basic authentication, we send a username and password as part of our request. When we provide a username and password, it allows us to access the resource. (request'in header'inde gonderirik bunu)
    ***401 =Unauthorized (yeni men seni tanimiram. Authentication bas vermiyib)
    ***base64Encode =bizim gonderdiymiz parol cevrilir base64 olraq encode olnur.

    //antMatchers();
    antMatchers() are used to configure the URL paths which either can be permitted or denied to a user http request, according the role or the authorization of that particular user.
    qisaca methoddur, hansiki user'lerin hansisa seyfeye girib gire bilmiyeceyini configure etmek ucun istfade edrik
    WebSecurityConfigurerAdapter= antMatcher methodumuzu elde etmek ucun SecurityConfiguration class duzeldib bundan extend edirik. bu klassi bu iki annotation ile markliyriq: @Configuration + @EnableWebSecurity
                                  configure methodunu override edib basliyriq.
    20.45-21.55= bu 60saniyelik hisseni izle. configure icindeki butun methodlari anladir ve anliyirsan 60sn icinde








    //DERS2 ---------------------------------------------------------------------------------------
    //Topic= SpringSecurity(2)

    NoteTopics: creatingCustomUser; encodingPassword;

    //creatingCustomUser;
    SecurityConfig class'in icine baxa bilersen. Ordaki "userDetailsService" methoduna bax. Onunla edirik creat prosesini

    //encodingPassword;
    rucnoy edrik bu prosesi. (Lakin spring ozu default olaraq verdiyi password variydi e, bax o passwordu encode edir default olaraq bildym qederyle)
    PasswordConfig class'in icine bax. "BCryptPasswordEncoder"= bunu return edirik. strength'i de 10 qoyduq. Yeni qarmaqarisiqliq, uzunluq sevyesini
    Sonrada SecurityConfig classina inject edrik. En sonda userDetailsService methodunda password hissesinde istifade edrik passwordEncoder'mzi







    //DERS3 ---------------------------------------------------------------------------------------
    //Topic= SpringSecurity(3)

    NoteTopics: CreatingRoles; Permissions;

    //Permissions;
    ilk once bunun enumunu duzeltdik. Ve permission enumlarini create etdik.

    //CreatingRoles;
    sonra Role'larin enumunu duzeltdik. Ve 2 role teyin etdik: ADMIN, STUDENT
    Sonra hashSet vasitesiyle permission set'lerimizi Role'lara teyin etdik
    *com.google.guava:guava:31.1-jre =bunu add etdk dependency olaraq. ki enumda Sets.newHashSet'i istf ede bilek
    Sonra SecurityConfig clasimizin "UserDetailsService" methodunda roles hissesine role'lari teyin etdik
    En sonda yene hemin classin "configure" methodunda yeni bir antmatchers acib endpoint yazdiq. Ve ona hasRole ile kimlerin daxil ola bileceyini teyin etdik







    //DERS4 ---------------------------------------------------------------------------------------
    //Topic= SpringSecurity(Final-JWT)

    NoteTopics: basic.vs.jwtAuthentication; credentialNedir; advantagesOfJwt; statelessNIyeOlmalidirMicroServ; jwtToken;
                newProjectAcdiq(gradle;.yml;h2); io.jsonwebtoken:jjwt:0.9.1; JwtService; @PostConstruct; UserDetailsServiceImpl;
                HomeController; SecurityConfig; SecurityFilterChain; csrf.disable; tkrarNiyeStateles; jwtFilter; test;

    ***Security qosuludursa, Authenticate olmamisiqsa 401 unAuthorized alaciyiq. Authenticate olmusuqsa lakin permision yoxdursa 403 Forbidden alaciyiq

    //basic.vs.jwtAuthentication;
    https://stackoverflow.com/questions/64676956/can-anyone-tell-me-the-difference-between-basic-authentication-and-jwt-token
    qisaca deirki basic'de biz credentials gonderirik (yeni,username ve sifreni). Ama bu coxda yaxsi sey deil. (credentials gondermek)
    O sebebden jwt istifade olnur. credentials yerine tokenler ile server ile elaqe qururuq.

    //credentialNedir;
    A login credential is a set of unique identifiers–such as a username and password–that enables a user to verify identity in order to log in to an online account.

    //advantagesOfJwt;
    Authentication prosesini suretlendirir. Cunki database ile elaqeye ehtiyac yoxdu. Butun datani oz icinde saxliyir
    stateles'dir. Yeniki ozunde bir session saxlamir. (biz misal microservice'lerle isliyrikse bizde session mentiqi olmamalidir. session stateless olmalidir)

    //statelessNIyeOlmalidirMicroServ;
    4.45-7.00 =anladir ki niye stateless olmalidir microservice'lerle isliyirikse. (docker, kubernetes, microservice oyrndkden sonra tkr bax bura. indi onlara aid terminler istf edir deye tam anlasilmir)

    //jwtToken;
    3hissesi var.
    header= (algorithm & tokenType).
    payload= (data). claim'ler deyilir bu hisseye. date, name vs ola bilir
    signature= 1ci ve 2ci hissedeki data'nin encode olunmus varianti burda yerlesir. (base64ile encode olnur)

    //yeniProjectAcdiq(gradle;.yml;h2);
    security-jwt.
    gradle =bununla create etdik. maven ile yox. cunki .yml istifade ede bilmedim maven'da. axtarib cozmek olar belke ama vaxtim suan yox. hemde gradle'in dadinada baxmis olaram. (+sorussalar gradle ile de islemisem)
    application.properties'i deyisdirdik to ".yml"e. "h2" database aktiv etdik.
    "h2" database'den istf edeciyik. mysql, postgre ehtyac yoxdu.

    //io.jsonwebtoken:jjwt:0.9.1;
    bunu add edrik dependency olaraq. (gradle versiyasinda)

    //JwtService;
    bele bir service create edecyk. Hanski icinde methodlar olacaq. jwt'den claim'leri extract etmek vs ucun
    Ve bu methodlar butun proyektlerde demek olarki eynidir zaten. (yeni JwtService servisi butun projectlerde hemen hemen eyni olacaq)
    getBody()= extract methodunda bu methoddan istf ederek return eletdiririk. body = claims. getbody dedikde tokendeki claims hissesini elde edeciyik

    //@PostConstruct;
    (28.50-29.50) 4 user create edib repository'e save edrik. (nece etdiymize burdan baxa bilersen. veya application classina bax)
    @PostConstruct= bunu yigisdirdiqda methodun adi qaralir. bunu qoyduqda ise sari olur, yeni cagrilir method demekdir bu. texminimce bu annotation o ise yariyirki, proyekt run olduqda bu annotation altindaki methodda run olnacaq. klassik usulla cagrilmamis olmasina baxmiyaraq

    //UserDetailsServiceImpl;
    UserDetailsService qoymadiq adini. cunki security icinde bu adda klass var

    //HomeController;
    endpoint'li methodlarimizda sadece ResponseEntity deil basqa seylerde return ede bileceymzi gormus olduq. Misal String return etdik

    //SecurityConfig;
    bu klass'da standart olur (anladigim qederyle butun proyektlerde buda olur ve texmini bele olur)

    //WebSecurityConfigurerAdapter.and.SecurityFilterChain;
    springin 3.0 versiyasindan sonra artiq tamamen deprecated olnub ="WebSecurityConfigurerAdapter"
    Onun yerine SecurityFilterChain istifade olnur. calisin bundan istfade edin. (Ozu etmedi. Cunki tezedi bu interface deye ayrintili bilmir deye bulasmaq istemedi deyesen)

    //csrf.disable;
    Ona gore disable edirikki, basqa port,linklerden bize sorgu gondere bilmesinler. (Cunki misal gondere bilse, ve deykki mailden bize ekil gonderdi kimse, ki ac yaxsi olacaq. acirsan arxaplanda api isliyir ve melumatlari alir gonderir vs. dediki ozu bele bilir)

    //tkrarNiyeStateles;
    tkr izah etdi qisaca niye microserv'de stateless olmalidir. state olmaginin niye menasi yoxdur deye. (dediki eger kubernetes istfade edirsizse)
    menasi yoxdu cunki microserv'de bizim application'mizin misal 4 dene dublicate'i olacaq. Ve bunlarin bir birinden session acilma vs sohbetlerinden xeberi olmuyacaq. state acilsa bele diger app'de istf ede bilmiyeceksen. (anlatdigndan men bele anladim. yenede microserviceden sonra tkr baxarsan anliyarsan)

    //jwtFilter;
    doFilterInternal= bu methodla tokeni oxyaciyiq. coxyerde bele gormusem ona gore bele yazram ama ezberlememisem. (ezberlemenize ehtiyac yoxdu, standart olraq beledi fln dedi 49.10-49.21) (cunki cox qarisiq seyler yazriq belli yerden sonra ona gore deme ehtyaci duydu mence ki izahini bilmir zaten ehtyacda olmadigni dusnur)
    request.getHeader("Authorization")= Postman'de post sorgusuna cevir. jwt Bearer et Authorization'i. Sonra Headers hissesinde "Authorization" hissesine get. Oradaki Authorization key'i goturmeye calsiriq bu methodun bu hissesiyle
    50.25-53.11 =ozetKecir bu methodda ne etdiymizi (iclerinde en qarsiq klass bu oldu. Ama dediyim kimi standart seylerdi ezberlemeye fln ehtyac yoxdu)
    son olraq JwtFilter classi inject etdik SecurityConfig class'a ve http.addFilterBefore'da istfade etdik
    ****ve xeta almiyaq deye en son olraqda AuthenticationManager'in bean'ini duzeldirikki "HomeController"a inject oluna bilsin (SecurityConfig icinde edrik bunu)
    
    //test;
    54.50- test edrik isliyirmi her sey
    error= "invalid username or password" => {noop} yazdiq password'larin basina. eslinde encode etmeliyik ama bunu yazmaqla sancaqki encode olunub ve isliyecek (basni aldadiriq ama encode edersen duzgun proyektde)

    56ci deqden sonrasina bax. sende niyese islemedi noop cozumu. en pis halda duzgun database qos. ora insert ele user ve paswwordlari. ele yoxla (eger oda alinmasa hecne belecede qoy. herseyi etmisen)
    (bir qaldi refreshtoken meselesi onuda dedi yutubdan baxib ede bilersiz. cunki 10 saat sonra olur token)









































































 */

}



