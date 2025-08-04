package texto;

import java.util.List;

/**
 *
 * @author Cooler Master
 */
public class BookList {
    public List<String> libros = List.of("genesis","exodo","levitico","numeros",
        "deuteronomio","josue","jueces","rut","samuel","samuel","reyes","reyes","cronicas",
        "cronicas","esdras","nehemias","ester","job","salmos","proverbios","eclesiastes",
        "cantares","isaias","jeremias","lamentaciones","ezequiel","daniel","oseas",
        "joel","amos","abdias", "jonas","miqueas","nahum","habacuc","sofonias","hageo","zacarias",
        "malaquias","mateo","marcos","lucas","juan","hechos","romanos","corintios",
        "corintios","galatas","efesios","filipenses","colosenses","tesalonicenses",
        "tesalonicenses","timoteo","timoteo","tito","filemon","hebreos","santiago",
        "pedro","pedro","juan","juan","juan","judas","apocalipsis");
    
    public List<String> carpetas = List.of(
        "genesis","exodo","levitico","numeros","deuteronomio","josue","jueces","rut",
        "samuel1","samuel2","reyes1","reyes2","cronicas1","cronicas2","esdras","nehemias",
        "ester","job","salmos","proverbios","eclesiastes","cantares","isaias","jeremias",
        "lamentaciones","ezequiel","daniel","oseas","joel","amos","abdias","jonas","miqueas",
        "nahum","habacuc","sofonias","hageo","zacarias","malaquias","mateo","marcos",
        "lucas","juan","hechos","romanos","corintios1","corintios2","galatas","efesios",
        "filipenses","colosenses","tesalonicenses1","tesalonicenses2","timoteo1","timoteo2",
        "tito","filemon","hebreos","santiago","pedro1","pedro2","juan1","juan2","juan3",
        "judas","apocalipsis"
    );
    
    public int[] capitulos = {
        50, 40, 27, 36, 34, 24, 21, 4, 31, 24,
        22, 25, 29, 36, 10, 13, 10, 42, 150, 31, 12, 8, 66, 52, 5,
        48, 12, 14, 3, 9, 1, 4, 7, 3, 3, 3, 2, 14, 4, 28,
        16, 24, 21, 28, 16, 16, 13, 6, 6, 4, 4, 5, 3, 6, 4, 3, 1,
        13, 5, 5, 3, 5, 1, 1, 1, 22
    };
}

/*addButton(gen, "Recursos/Biblia_en_texto/genesis/", "genesis", 50);
        addButton(exo, "Recursos/Biblia_en_texto/exodo/", "exodo", 40);
        addButton(lev, "Recursos/Biblia_en_texto/levitico/", "levitico", 27);
        addButton(num, "Recursos/Biblia_en_texto/numeros/", "numeros", 36);
        addButton(deu, "Recursos/Biblia_en_texto/deuteronomio/", "deuteronomio", 34);
        addButton(jos, "Recursos/Biblia_en_texto/josue/", "josue", 24);
        addButton(jue, "Recursos/Biblia_en_texto/jueces/", "jueces", 21);
        addButton(rut, "Recursos/Biblia_en_texto/rut/", "rut", 4);
        addButton(samuel1, "Recursos/Biblia_en_texto/samuel1/", "samuel", 31);
        addButton(samuel2, "Recursos/Biblia_en_texto/samuel2/", "samuel", 24);
        addButton(reyes1, "Recursos/Biblia_en_texto/reyes1/", "reyes", 22);
        addButton(reyes2, "Recursos/Biblia_en_texto/reyes2/", "reyes", 25);
        addButton(cronicas1, "Recursos/Biblia_en_texto/cronicas1/", "cronicas", 29);
        addButton(cronicas2, "Recursos/Biblia_en_texto/cronicas2/", "cronicas", 36);
        addButton(esdras, "Recursos/Biblia_en_texto/esdras/", "esdras", 10);
        addButton(nehemias, "Recursos/Biblia_en_texto/nehemias/", "nehemias", 13);
        addButton(ester, "Recursos/Biblia_en_texto//ester/", "ester", 10);
        addButton(job, "Recursos/Biblia_en_texto/job/", "job", 42);
        addButton(salmos, "Recursos/Biblia_en_texto/salmos/", "salmos", 150);
        addButton(proverbios, "Recursos/Biblia_en_texto/proverbio/", "proverbios", 31);
        addButton(eclesiastes, "Recursos/Biblia_en_texto/eclesiastes/", "eclesiastes", 12);
        addButton(cantares, "Recursos/Biblia_en_texto/cantares/", "cantares", 8);
        addButton(isaias, "Recursos/Biblia_en_texto/isaias/", "isaias", 66);
        addButton(jeremias, "Recursos/Biblia_en_texto/jeremias/", "jeremias", 52);
        addButton(lamentaciones, "Recursos/Biblia_en_texto/lamentaciones/", "lamentaciones", 5);
        addButton(ezequiel, "Recursos/Biblia_en_texto/ezequiel/", "ezequiel", 48);
        addButton(daniel, "Recursos/Biblia_en_texto/daniel/", "daniel", 12);
        addButton(oseas, "Recursos/Biblia_en_texto/oseas/", "oseas", 14);
        addButton(joel, "Recursos/Biblia_en_texto/jel/", "joel", 3);
        addButton(amos, "Recursos/Biblia_en_texto/amos/", "amos", 9);
        addButton(abdias, "Recursos/Biblia_en_texto/abdias/", "abdias", 1);
        addButton(jonas, "Recursos/Biblia_en_texto/jonas/", "jonas", 4);
        addButton(miqueas, "Recursos/Biblia_en_texto/miqueas/", "miqueas", 7);
        addButton(nahum, "Recursos/Biblia_en_texto/nahum/", "nahum", 3);
        addButton(habacuc, "Recursos/Biblia_en_texto/habacuc/", "habacuc", 3);
        addButton(sofonias, "Recursos/Biblia_en_texto/sofonias/", "sofonias", 3);
        addButton(hageo, "Recursos/Biblia_en_texto/hageo/", "hageo", 2);
        addButton(zacarias, "Recursos/Biblia_en_texto/zacarias/", "zacarias", 14);
        addButton(malaquias, "Recursos/Biblia_en_texto/malaquias/", "malaquias", 4);
        //Nuevo testamento
        addButton(mateo, "Recursos/Biblia_en_texto/mateo/", "mateo", 28);
        addButton(marcos, "Recursos/Biblia_en_texto/marcos/", "marcos", 16);
        addButton(lucas, "Recursos/Biblia_en_texto/lucas/", "lucas", 24);
        addButton(juan, "Recursos/Biblia_en_texto/juan/", "juan", 21);
        addButton(hechos, "Recursos/Biblia_en_texto/hechos/", "hechos", 28);
        addButton(romanos, "Recursos/Biblia_en_texto/romanos/", "romanos", 16);
        addButton(corintios1, "Recursos/Biblia_en_texto/corintios1/", "corintios", 16);
        addButton(corintios2, "Recursos/Biblia_en_texto/corintios2/", "corintios", 13);
        addButton(galatas, "Recursos/Biblia_en_texto/galatas/", "galatas", 6);
        addButton(efesios, "Recursos/Biblia_en_texto/efesios/", "efesios", 6);
        addButton(filipenses, "Recursos/Biblia_en_texto/filipenses/", "filipenses", 4);
        addButton(colosenses, "Recursos/Biblia_en_texto/colosenses/", "colosenses", 4);
        addButton(tesalonicenses1, "Recursos/Biblia_en_texto/tesalonicenses1/", "tesalonicenses", 5);
        addButton(tesalonicenses2, "Recursos/Biblia_en_texto/tesalonicenses2/", "tesalonicenses", 3);
        addButton(timoteo1, "Recursos/Biblia_en_texto/timoteo1/", "timoteo", 6);
        addButton(timoteo2, "Recursos/Biblia_en_texto/timoteo2/", "timoteo", 4);
        addButton(tito, "Recursos/Biblia_en_texto/tito/", "tito", 3);
        addButton(filemon, "Recursos/Biblia_en_texto/filemon/", "filemon", 1);
        addButton(hebreos, "Recursos/Biblia_en_texto/hebreos/", "hebreos", 13);
        addButton(santiago, "Recursos/Biblia_en_texto/santiago/", "santiago", 5);
        addButton(pedro1, "Recursos/Biblia_en_texto/pedro1/", "pedro", 5);
        addButton(pedro2, "Recursos/Biblia_en_texto/pedro2/", "pedro", 3);
        addButton(juan1, "Recursos/Biblia_en_texto/juan1/", "juan", 5);
        addButton(juan2, "Recursos/Biblia_en_texto/juan2/", "juan", 1);
        addButton(juan3, "Recursos/Biblia_en_texto/juan3/", "juan", 1);
        addButton(judas, "Recursos/Biblia_en_texto/judas/", "judas", 1);
        addButton(apocalipsis, "Recursos/Biblia_en_texto/apocalipsis/", "apocalipsis", 22);*/