package org.celllife.idart.common;

import static org.celllife.idart.common.FormCode.formCode;

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-18
 * Time: 13h12
 */
public enum Forms {

    AER(formCode("AER"),"Aerosol"),
    APPFUL(formCode("APPFUL"),"applicatorful"),
    BAINHL(formCode("BAINHL"),"Breath Activated Inhaler"),
    BAINHLPWD(formCode("BAINHLPWD"),"Breath Activated Powder Inhaler"),
    BAR(formCode("BAR"),"Bar"),
    BARSOAP(formCode("BARSOAP"),"Bar Soap"),
    BEAD(formCode("BEAD"),"Beads", "A solid dosage form in the shape of a small ball."),
    BUCTAB(formCode("BUCTAB"),"Buccal Tablet"),
    CAKE(formCode("CAKE"),"Cake"),
    CAP(formCode("CAP"),"Capsule", "A solid dosage form in which the drug is enclosed within either a hard or soft soluble container or \"shell\" made from a suitable form of gelatin."),
    CAPLET(formCode("CAPLET"),"Caplet"),
    CEMENT(formCode("CEMENT"),"Cement", "A substance that serves to produce solid union between two surfaces."),
    CHEWBAR(formCode("CHEWBAR"),"Chewable Bar", "A solid dosage form usually in the form of a rectangle that is meant to be chewed."),
    CHEWTAB(formCode("CHEWTAB"),"Chewable Tablet", "A solid dosage form containing medicinal substances with or without suitable diluents that is intended to be chewed, producing a pleasant tasting residue in the oral cavity that is easily swallowed and does not leave a bitter or unpleasant after-taste."),
    CPTAB(formCode("CPTAB"),"Coated Particles Tablet"),
    CRM(formCode("CRM"),"Cream", "A semisolid dosage form containing one or more drug substances dissolved or dispersed in a suitable base; more recently, the term has been restricted to products consisting of oil-in-water emulsions or aqueous microcrystalline dispersions of long chain fatty acids or alcohols that are water washable and more cosmetically and aesthetically acceptable."),
    CRYS(formCode("CRYS"),"Crystals", "A naturally produced angular solid of definite form in which the ultimate units from which it is built up are systematically arranged; they are usually evenly spaced on a regular space lattice."),
    DERMSPRY(formCode("DERMSPRY"),"Dermal Spray"),
    DISINTAB(formCode("DISINTAB"),"Disintegrating Tablet", "A solid dosage form containing medicinal substances which disintegrates rapidly, usually within a matter of seconds, when placed upon the tongue."),
    DISK(formCode("DISK"),"Disk", "A circular plate-like organ or structure."),
    DOUCHE(formCode("DOUCHE"),"Douche", "A liquid preparation, intended for the irrigative cleansing of the vagina, that is prepared from powders, liquid solutions, or liquid concentrates and contains one or more chemical substances dissolved in a suitable solvent or mutually miscible solvents."),
    DROP(formCode("DROP"),"Drops"),
    DRTAB(formCode("DRTAB"),"Delayed Release Tablet"),
    ECTAB(formCode("ECTAB"),"Enteric Coated Tablet"),
    ELIXIR(formCode("ELIXIR"),"Elixir", "A clear, pleasantly flavored, sweetened hydroalcoholic liquid containing dissolved medicinal agents; it is intended for oral use."),
    ENEMA(formCode("ENEMA"),"Enema", "A rectal preparation for therapeutic, diagnostic, or nutritive purposes."),
    ENTCAP(formCode("ENTCAP"),"Enteric Coated Capsule"),
    ERCAP(formCode("ERCAP"),"Extended Release Capsule", "A solid dosage form in which the drug is enclosed within either a hard or soft soluble container made from a suitable form of gelatin, and which releases a drug(or drugs) in such a manner to allow a reduction in dosing frequency as compared to that drug(or drugs) presented as a conventional dosage form."),
    ERCAP12(formCode("ERCAP12"),"12 Hour Extended Release Capsule"),
    ERCAP24(formCode("ERCAP24"),"24 Hour Extended Release Capsule"),
    ERECCAP(formCode("ERECCAP"),"Extended Release Enteric Coated Capsule"),
    ERECTAB(formCode("ERECTAB"),"Extended Release Enteric Coated Tablet"),
    ERENTCAP(formCode("ERENTCAP"),"Extended Release Enteric Coated Capsule"),
    ERSUSP(formCode("ERSUSP"),"Extended-Release Suspension"),
    ERSUSP12(formCode("ERSUSP12"),"12 Hour Extended-Release Suspension"),
    ERSUSP24(formCode("ERSUSP24"),"24 Hour Extended Release Suspension"),
    ERTAB(formCode("ERTAB"),"Extended Release Tablet", "A solid dosage form containing a drug which allows at least a reduction in dosing frequency as compared to that drug presented in conventional dosage form."),
    ERTAB12(formCode("ERTAB12"),"12 Hour Extended Release Tablet"),
    ERTAB24(formCode("ERTAB24"),"24 Hour Extended Release Tablet"),
    FLAKE(formCode("FLAKE"),"Flakes"),
    FOAM(formCode("FOAM"),"Foam"),
    FOAMAPL(formCode("FOAMAPL"),"Foam with Applicator"),
    GASINHL(formCode("GASINHL"),"Gas for Inhalation"),
    GEL(formCode("GEL"),"Gel", "A semisolid system consisting of either suspensions made up of small inorganic particles or large organic molecules interpenetrated by a liquid."),
    GELAPL(formCode("GELAPL"),"Gel with Applicator"),
    GRAN(formCode("GRAN"),"Granules", "A small particle or grain."),
    GUM(formCode("GUM"),"ChewingGum", "A sweetened and flavored insoluble plastic material of various shapes which when chewed, releases a drug substance into the oral cavity."),
    INHL(formCode("INHL"),"Inhalant"),
    INHLPWD(formCode("INHLPWD"),"Inhalant Powder"),
    INHLSOL(formCode("INHLSOL"),"Inhalant Solution"),
    IPSOL(formCode("IPSOL"),"Intraperitoneal Solution"),
    IRSOL(formCode("IRSOL"),"Irrigation Solution", "A sterile solution intended to bathe or flush open wounds or body cavities; they're used topically, never parenterally."),
    ITSUSP(formCode("ITSUSP"),"Intrathecal Suspension"),
    IVSOL(formCode("IVSOL"),"Intravenous Solution"),
    LIN(formCode("LIN"),"Liniment", "A solution or mixture of various substances in oil, alcoholic solutions of soap, or emulsions intended for external application."),
    LIQCLN(formCode("LIQCLN"),"Liquid Cleanser"),
    LIQSOAP(formCode("LIQSOAP"),"Medicated Liquid Soap"),
    LTN(formCode("LTN"),"Lotion", "The term \"lotion\" has been used to categorize many topical suspensions, solutions and emulsions intended for application to the skin."),
    MDINHL(formCode("MDINHL"),"Metered Dose Inhaler"),
    MDINHLPWD(formCode("MDINHLPWD"),"Metered Dose Powder Inhaler"),
    MEDBAR(formCode("MEDBAR"),"Medicated Bar Soap"),
    MEDPAD(formCode("MEDPAD"),"Medicated Pad"),
    MEDSWAB(formCode("MEDSWAB"),"Medicated swab"),
    MUCTOPSOL(formCode("MUCTOPSOL"),"Mucous Membrane Topical Solution"),
    NASCRM(formCode("NASCRM"),"Nasal Cream"),
    NASGEL(formCode("NASGEL"),"Nasal Gel"),
    NASINHL(formCode("NASINHL"),"Nasal Inhalant"),
    NASOINT(formCode("NASOINT"),"Nasal Ointment"),
    NASSPRY(formCode("NASSPRY"),"Nasal Spray"),
    NDROP(formCode("NDROP"),"Nasal Drops"),
    OIL(formCode("OIL"),"Oil", "An unctuous, combustible substance which is liquid, or easily liquefiable, on warming, and is soluble in ether but insoluble in water. Such substances, depending on their origin, are classified as animal, mineral, or vegetable oils."),
    OINT(formCode("OINT"),"Ointment", "A semisolid preparation intended for external application to the skin or mucous membranes."),
    OINTAPL(formCode("OINTAPL"),"Ointment with Applicator"),
    OPCRM(formCode("OPCRM"),"Ophthalmic Cream"),
    OPDROP(formCode("OPDROP"),"Ophthalmic Drops"),
    OPGEL(formCode("OPGEL"),"Ophthalmic Gel"),
    OPIRSOL(formCode("OPIRSOL"),"Ophthalmic Irrigation Solution"),
    OPOINT(formCode("OPOINT"),"Ophthalmic Ointment"),
    OPSUSP(formCode("OPSUSP"),"Ophthalmic Suspension"),
    ORALSOL(formCode("ORALSOL"),"Oral Solution"),
    ORCAP(formCode("ORCAP"),"Oral Capsule"),
    ORCRM(formCode("ORCRM"),"Oral Cream"),
    ORDROP(formCode("ORDROP"),"Oral Drops"),
    ORINHL(formCode("ORINHL"),"Oral Inhalant"),
    ORSUSP(formCode("ORSUSP"),"Oral Suspension"),
    ORTAB(formCode("ORTAB"),"Oral Tablet"),
    ORTROCHE(formCode("ORTROCHE"),"Lozenge/Oral Troche", "A solid preparation containing one or more medicaments, usually in a flavored, sweetened base which is intended to dissolve or disintegrate slowly in the mouth."),
    OTCRM(formCode("OTCRM"),"Otic Cream"),
    OTDROP(formCode("OTDROP"),"Otic Drops"),
    OTGEL(formCode("OTGEL"),"Otic Gel"),
    OTOINT(formCode("OTOINT"),"Otic Ointment"),
    OTSUSP(formCode("OTSUSP"),"Otic Suspension"),
    PAD(formCode("PAD"),"Pad"),
    PASTE(formCode("PASTE"),"Paste", "A semisolid dosage form that contains one or more drug substances intended for topical application."),
    PATCH(formCode("PATCH"),"Patch", "A drug delivery system that contains an adhesived backing and that permits its ingredients to diffuse from some portion of it(e.g., the backing itself, a reservoir, the adhesive, or some other component) into the body from the external site where it is applied."),
    PELLET(formCode("PELLET"),"Pellet", "A small sterile solid mass consisting of a highly purified drug(with or without excipients) made by the formation of granules, or by compression and molding."),
    PILL(formCode("PILL"),"Pill", "A small, round solid dosage form containing a medicinal agent intended for oral administration."),
    POWD(formCode("POWD"),"Powder", "An intimate mixture of dry, finely divided drugs and/or chemicals that may be intended for internal or external use."),
    PUD(formCode("PUD"),"Pudding"),
    PUFF(formCode("PUFF"),"puff"),
    PWDSPRY(formCode("PWDSPRY"),"Powder Spray"),
    RECCRM(formCode("RECCRM"),"Rectal Cream"),
    RECOINT(formCode("RECOINT"),"Rectal Ointment"),
    RECPWD(formCode("RECPWD"),"Rectal Powder"),
    RECSOL(formCode("RECSOL"),"Rectal Solution"),
    RECSPRY(formCode("RECSPRY"),"Rectal Spray"),
    RECSUPP(formCode("RECSUPP"),"Rectal Suppository"),
    RECSUSP(formCode("RECSUSP"),"Rectal Suspension"),
    RECformCode(formCode("RECFORM"),"Rectal foam"),
    RINSE(formCode("RINSE"),"Mouthwash/Rinse", "An aqueous solution which is most often used for its deodorant, refreshing, or antiseptic effect."),
    SCOOP(formCode("SCOOP"),"scoops"),
    SHMP(formCode("SHMP"),"Shampoo", "A liquid soap or detergent used to clean the hair and scalp and is often used as a vehicle for dermatologic agents."),
    SLTAB(formCode("SLTAB"),"Sublingual Tablet"),
    SOL(formCode("SOL"),"Solution", "A liquid preparation that contains one or more chemical substances dissolved, i.e., molecularly dispersed, in a suitable solvent or mixture of mutually miscible solvents."),
    SPRY(formCode("SPRY"),"sprays"),
    SPRYADAPT(formCode("SPRYADAPT"),"Spray with Adaptor"),
    SRBUCTAB(formCode("SRBUCTAB"),"Sustained Release Buccal Tablet"),
    SUPP(formCode("SUPP"),"Suppository", "A solid body of various weights and shapes, adapted for introduction into the rectal, vaginal, or urethral orifice of the human body; they usually melt, soften, or dissolve at body temperature."),
    SUSP(formCode("SUSP"),"Suspension"),
    SWAB(formCode("SWAB"),"Swab", "A wad of absorbent material usually wound around one end of a small stick and used for applying medication or for removing material from an area."),
    SYRUP(formCode("SYRUP"),"Syrup", "An oral solution containing high concentrations of sucrose or other sugars; the term has also been used to include any other liquid dosage form prepared in a sweet and viscid vehicle, including oral suspensions."),
    TAB(formCode("TAB"),"Tablet", "A solid dosage form containing medicinal substances with or without suitable diluents."),
    TINC(formCode("TINC"),"Tincture"),
    TOPCRM(formCode("TOPCRM"),"Topical Cream"),
    TOPGEL(formCode("TOPGEL"),"Topical Gel"),
    TOPLTN(formCode("TOPLTN"),"Topical Lotion"),
    TOPOIL(formCode("TOPOIL"),"Topical Oil"),
    TOPOINT(formCode("TOPOINT"),"Topical Ointment"),
    TOPPWD(formCode("TOPPWD"),"Topical Powder"),
    TOPSOL(formCode("TOPSOL"),"Topical Solution"),
    TPASTE(formCode("TPASTE"),"Toothpaste", "A paste formulation intended to clean and/or polish the teeth, and which may contain certain additional agents."),
    TPATCH(formCode("TPATCH"),"Transdermal Patch"),
    TPATH16(formCode("TPATH16"),"16 Hour Transdermal Patch"),
    TPATH24(formCode("TPATH24"),"24 Hour Transdermal Patch"),
    TPATH2WK(formCode("TPATH2WK"),"Biweekly Transdermal Patch"),
    TPATH72(formCode("TPATH72"),"72 Hour Transdermal Patch"),
    TPATHWK(formCode("TPATHWK"),"Weekly Transdermal Patch"),
    URETHGEL(formCode("URETHGEL"),"Urethral Gel"),
    URETHSUPP(formCode("URETHSUPP"),"Urethral suppository"),
    VAGCRM(formCode("VAGCRM"),"Vaginal Cream"),
    VAGCRMAPL(formCode("VAGCRMAPL"),"Vaginal Cream with Applicator"),
    VAGFOAM(formCode("VAGFOAM"),"Vaginal foam"),
    VAGFOAMAPL(formCode("AGFOAMAPL"),"Vaginal foam with applicator"),
    VAGGEL(formCode("VAGGEL"),"Vaginal Gel"),
    VAGOINT(formCode("VAGOINT"),"Vaginal Ointment"),
    VAGOINTAPL(formCode("VAGOINTAPL"),"Vaginal Ointment with Applicator"),
    VAGPWD(formCode("VAGPWD"),"Vaginal Powder"),
    VAGSPRY(formCode("VAGSPRY"),"Vaginal Spray"),
    VAGSUPP(formCode("VAGSUPP"),"Vaginal Suppository"),
    VAGTAB(formCode("VAGTAB"),"Vaginal Tablet"),
    VGELAPL(formCode("VGELAPL"),"Vaginal Gel with Applicator"),
    WAFER(formCode("WAFER"),"Wafer", "A thin slice of material containing a medicinal agent.");

    public final FormCode code;

    public final String name;

    public final String description;

    private Forms(FormCode code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    private Forms(FormCode code, String name) {
        this(code, name, null);
    }
}
