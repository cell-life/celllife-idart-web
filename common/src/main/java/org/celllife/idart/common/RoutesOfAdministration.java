package org.celllife.idart.common;

import static org.celllife.idart.common.RouteOfAdministrationCode.routeOfAdministrationCode;

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-18
 * Time: 13h36
 */
public enum RoutesOfAdministration {

    AMNINJ(routeOfAdministrationCode("AMNINJ"), "Injection, amniotic fluid"),
    BILINJ(routeOfAdministrationCode("BILINJ"), "Injection, biliary tract"),
    BLADINJ(routeOfAdministrationCode("BLADINJ"), "Injection, urinary bladder"),
    BLADINSTL(routeOfAdministrationCode("BLADINSTL"), "Instillation, urinary catheter"),
    BLADIRR(routeOfAdministrationCode("BLADIRR"), "Irrigation, urinary bladder"),
    BLADIRRC(routeOfAdministrationCode("BLADIRRC"), "Irrigation, urinary bladder, continuous"),
    BLADIRRT(routeOfAdministrationCode("BLADIRRT"), "Irrigation, urinary bladder, tidal"),
    BUC(routeOfAdministrationCode("BUC"), "Topical application, buccal"),
    CAPDINSTL(routeOfAdministrationCode("CAPDINSTL"), "Instillation, continuous ambulatory peritoneal dialysis port"),
    CECINSTL(routeOfAdministrationCode("CECINSTL"), "Instillation, cecostomy"),
    CERV(routeOfAdministrationCode("CERV"), "Topical application, cervical"),
    CERVINJ(routeOfAdministrationCode("CERVINJ"), "Injection, cervical"),
    CERVINS(routeOfAdministrationCode("CERVINS"), "Insertion, cervical (uterine)"),
    CHEW(routeOfAdministrationCode("CHEW"), "Chew, oral"),
    CHOLINJ(routeOfAdministrationCode("CHOLINJ"), "Injection, for cholangiography"),
    CTINSTL(routeOfAdministrationCode("CTINSTL"), "Instillation, chest tube"),
    DEN(routeOfAdministrationCode("DEN"), "Topical application, dental"),
    DENRINSE(routeOfAdministrationCode("DENRINSE"), "Rinse, dental"),
    DISSOLVE(routeOfAdministrationCode("DISSOLVE"), "Dissolve, oral"),
    DOUCHE(routeOfAdministrationCode("DOUCHE"), "Douche, vaginal"),
    DRESS(routeOfAdministrationCode("DRESS"), "Topical application, soaked dressing"),
    EFT(routeOfAdministrationCode("EFT"), "Instillation, enteral feeding tube"),
    ELECTOSMOS(routeOfAdministrationCode("ELECTOSMOS"), "Electro-osmosis"),
    ENDOSININJ(routeOfAdministrationCode("ENDOSININJ"), "Injection, endosinusial"),
    ENEMA(routeOfAdministrationCode("ENEMA"), "Enema, rectal"),
    ENTINSTL(routeOfAdministrationCode("ENTINSTL"), "Instillation, enteral"),
    EPI(routeOfAdministrationCode("EPI"), "Infusion, epidural"),
    EPIDURINJ(routeOfAdministrationCode("EPIDURINJ"), "Injection, epidural"),
    EPIINJ(routeOfAdministrationCode("EPIINJ"), "Injection, epidural, push"),
    EPINJSP(routeOfAdministrationCode("EPINJSP"), "Injection, epidural, slow push"),
    ETINSTL(routeOfAdministrationCode("ETINSTL"), "Instillation, endotracheal tube"),
    ETNEB(routeOfAdministrationCode("ETNEB"), "Nebulization, endotracheal tube"),
    EXTCORPDIF(routeOfAdministrationCode("EXTCORPDIF"), "Diffusion, extracorporeal"),
    EXTCORPINJ(routeOfAdministrationCode("EXTCORPINJ"), "Injection, extracorporeal"),
    EXTRAMNINJ(routeOfAdministrationCode("EXTRAMNINJ"), "Injection, extra-amniotic"),
    GARGLE(routeOfAdministrationCode("GARGLE"), "Gargle"),
    GBINJ(routeOfAdministrationCode("GBINJ"), "Injection, gastric button"),
    GIN(routeOfAdministrationCode("GIN"), "Topical application, gingival"),
    GINGINJ(routeOfAdministrationCode("GINGINJ"), "Injection, gingival"),
    GJT(routeOfAdministrationCode("GJT"), "Instillation, gastro-jejunostomy tube"),
    GT(routeOfAdministrationCode("GT"), "Instillation, gastrostomy tube"),
    GUIRR(routeOfAdministrationCode("GUIRR"), "Irrigation, genitourinary"),
    HAIR(routeOfAdministrationCode("HAIR"), "Topical application, hair"),
    HEMODIFF(routeOfAdministrationCode("HEMODIFF"), "Diffusion, hemodialysis"),
    HEMOPORT(routeOfAdministrationCode("HEMOPORT"), "Injection, hemodialysis port"),
    IA(routeOfAdministrationCode("IA"), "Infusion, intraarterial catheter"),
    IABDINJ(routeOfAdministrationCode("IABDINJ"), "Injection, intra-abdominal"),
    IAINJ(routeOfAdministrationCode("IAINJ"), "Injection, intraarterial"),
    IAINJP(routeOfAdministrationCode("IAINJP"), "Injection, intraarterial, push"),
    IAINJSP(routeOfAdministrationCode("IAINJSP"), "Injection, intraarterial, slow push"),
    IARTINJ(routeOfAdministrationCode("IARTINJ"), "Injection, intraarticular"),
    IBRONCHINSTIL(routeOfAdministrationCode("IBRONCHINSTIL"), "Instillation, intrabronchial"),
    IBURSINJ(routeOfAdministrationCode("IBURSINJ"), "Injection, intrabursal"),
    IC(routeOfAdministrationCode("IC"), "Infusion, intracardiac"),
    ICARDINJ(routeOfAdministrationCode("ICARDINJ"), "Injection, intracardiac"),
    ICARDINJRP(routeOfAdministrationCode("ICARDINJRP"), "Injection, intracardiac, rapid push"),
    ICARDINJSP(routeOfAdministrationCode("ICARDINJSP"), "Injection, intracardiac, slow push"),
    ICARINJP(routeOfAdministrationCode("ICARINJP"), "Injection, intracardiac, push"),
    ICARTINJ(routeOfAdministrationCode("ICARTINJ"), "Injection, intracartilaginous"),
    ICAUDINJ(routeOfAdministrationCode("ICAUDINJ"), "Injection, intracaudal"),
    ICAVINJ(routeOfAdministrationCode("ICAVINJ"), "Injection, intracavernous"),
    ICAVITINJ(routeOfAdministrationCode("ICAVITINJ"), "Injection, intracavitary"),
    ICEREBINJ(routeOfAdministrationCode("ICEREBINJ"), "Injection, intracerebral"),
    ICISTERNINJ(routeOfAdministrationCode("ICISTERNINJ"), "Injection, intracisternal"),
    ICOR(routeOfAdministrationCode("ICOR"), "Infusion, intracoronary"),
    ICORNTA(routeOfAdministrationCode("ICORNTA"), "Topical application, intracorneal"),
    ICORONINJ(routeOfAdministrationCode("ICORONINJ"), "Injection, intracoronary"),
    ICORONINJP(routeOfAdministrationCode("ICORONINJP"), "Injection, intracoronary, push"),
    ICORONTA(routeOfAdministrationCode("ICORONTA"), "Topical application, intracoronal (dental)"),
    ICORPCAVINJ(routeOfAdministrationCode("ICORPCAVINJ"), "Injection, intracorpus cavernosum"),
    IDIMPLNT(routeOfAdministrationCode("IDIMPLNT"), "Implantation, intradermal"),
    IDINJ(routeOfAdministrationCode("IDINJ"), "Injection, intradermal"),
    IDISCINJ(routeOfAdministrationCode("IDISCINJ"), "Injection, intradiscal"),
    IDOUDMAB(routeOfAdministrationCode("IDOUDMAB"), "Mucosal absorption, intraduodenal"),
    IDUCTINJ(routeOfAdministrationCode("IDUCTINJ"), "Injection, intraductal"),
    IDUODINSTIL(routeOfAdministrationCode("IDUODINSTIL"), "Instillation, intraduodenal"),
    IDURINJ(routeOfAdministrationCode("IDURINJ"), "Injection, intradural"),
    IEPIDINJ(routeOfAdministrationCode("IEPIDINJ"), "Injection, intraepidermal"),
    IEPITHINJ(routeOfAdministrationCode("IEPITHINJ"), "Injection, intraepithelial"),
    IESOPHINSTIL(routeOfAdministrationCode("IESOPHINSTIL"), "Instillation, intraesophageal"),
    IESOPHTA(routeOfAdministrationCode("IESOPHTA"), "Topical application, intraesophageal"),
    IGASTINSTIL(routeOfAdministrationCode("IGASTINSTIL"), "Instillation, intragastric"),
    IGASTIRR(routeOfAdministrationCode("IGASTIRR"), "Irrigation, intragastric"),
    IGASTLAV(routeOfAdministrationCode("IGASTLAV"), "Lavage, intragastric"),
    IILEALINJ(routeOfAdministrationCode("IILEALINJ"), "Instillation, intraileal"),
    IILEALTA(routeOfAdministrationCode("IILEALTA"), "Topical application, intraileal"),
    ILESINJ(routeOfAdministrationCode("ILESINJ"), "Injection, intralesional"),
    ILESIRR(routeOfAdministrationCode("ILESIRR"), "Irrigation, intralesional"),
    ILTOP(routeOfAdministrationCode("ILTOP"), "Topical application, intralesional"),
    ILUMINJ(routeOfAdministrationCode("ILUMINJ"), "Injection, intraluminal"),
    ILUMTA(routeOfAdministrationCode("ILUMTA"), "Topical application, intraluminal"),
    ILYMPJINJ(routeOfAdministrationCode("ILYMPJINJ"), "Injection, intralymphatic"),
    IM(routeOfAdministrationCode("IM"), "Injection, intramuscular"),
    IMD(routeOfAdministrationCode("IMD"), "Injection, intramuscular, deep"),
    IMZ(routeOfAdministrationCode("IMZ"), "Injection, intramuscular, z track"),
    IMEDULINJ(routeOfAdministrationCode("IMEDULINJ"), "Injection, intramedullary"),
    INSUF(routeOfAdministrationCode("INSUF"), "Insufflation"),
    INTERMENINJ(routeOfAdministrationCode("INTERMENINJ"), "Injection, interameningeal"),
    INTERSTITINJ(routeOfAdministrationCode("INTERSTITINJ"), "Injection, interstitial"),
    IOINJ(routeOfAdministrationCode("IOINJ"), "Injection, intraocular"),
    IOINSTL(routeOfAdministrationCode("IOINSTL"), "Instillation, intraocular"),
    IOIRR(routeOfAdministrationCode("IOIRR"), "Irrigation, intraocular"),
    IONTO(routeOfAdministrationCode("IONTO"), "Topical application, iontophoresis"),
    IOSSC(routeOfAdministrationCode("IOSSC"), "Infusion, intraosseous, continuous"),
    IOSSINJ(routeOfAdministrationCode("IOSSINJ"), "Injection, intraosseous"),
    IOSURGINS(routeOfAdministrationCode("IOSURGINS"), "Insertion, intraocular, surgical"),
    IOTOP(routeOfAdministrationCode("IOTOP"), "Topical application, intraocular"),
    IOVARINJ(routeOfAdministrationCode("IOVARINJ"), "Injection, intraovarian"),
    IPCARDINJ(routeOfAdministrationCode("IPCARDINJ"), "Injection, intrapericardial"),
    IPERINJ(routeOfAdministrationCode("IPERINJ"), "Injection, intraperitoneal"),
    IPINJ(routeOfAdministrationCode("IPINJ"), "Injection, intrapulmonary"),
    IPLRINJ(routeOfAdministrationCode("IPLRINJ"), "Injection, intrapleural"),
    IPPB(routeOfAdministrationCode("IPPB"), "Inhalation, intermittent positive pressure breathing (ippb)"),
    IPROSTINJ(routeOfAdministrationCode("IPROSTINJ"), "Injection, intraprostatic"),
    IPUMPINJ(routeOfAdministrationCode("IPUMPINJ"), "Injection, insulin pump"),
    ISININSTIL(routeOfAdministrationCode("ISININSTIL"), "Instillation, intrasinal"),
    ISINJ(routeOfAdministrationCode("ISINJ"), "Injection, intraspinal"),
    ISTERINJ(routeOfAdministrationCode("ISTERINJ"), "Injection, intrasternal"),
    ISYNINJ(routeOfAdministrationCode("ISYNINJ"), "Injection, intrasynovial"),
    IT(routeOfAdministrationCode("IT"), "Infusion, intrathecal"),
    ITENDINJ(routeOfAdministrationCode("ITENDINJ"), "Injection, intratendinous"),
    ITESTINJ(routeOfAdministrationCode("ITESTINJ"), "Injection, intratesticular"),
    ITHORINJ(routeOfAdministrationCode("ITHORINJ"), "Injection, intrathoracic"),
    ITINJ(routeOfAdministrationCode("ITINJ"), "Injection, intrathecal"),
    ITRACHINSTIL(routeOfAdministrationCode("ITRACHINSTIL"), "Instillation, intratracheal"),
    ITRACHMAB(routeOfAdministrationCode("ITRACHMAB"), "Mucosal absorption, intratracheal"),
    ITUBINJ(routeOfAdministrationCode("ITUBINJ"), "Injection, intratubular"),
    ITUMINJ(routeOfAdministrationCode("ITUMINJ"), "Injection, intratumor"),
    ITYMPINJ(routeOfAdministrationCode("ITYMPINJ"), "Injection, intratympanic"),
    IU(routeOfAdministrationCode("IU"), "Insertion, intrauterine"),
    IUINJ(routeOfAdministrationCode("IUINJ"), "Injection, intracervical (uterus)"),
    IUINJC(routeOfAdministrationCode("IUINJC"), "Injection, intracervical (uterus)"),
    IUINSTL(routeOfAdministrationCode("IUINSTL"), "Instillation, intrauterine"),
    IURETINJ(routeOfAdministrationCode("IURETINJ"), "Injection, intraureteral, retrograde"),
    IV(routeOfAdministrationCode("IV"), "Infusion, intravenous"),
    IVC(routeOfAdministrationCode("IVC"), "Infusion, intravenous catheter"),
    IVCC(routeOfAdministrationCode("IVCC"), "Infusion, intravenous catheter, continuous"),
    IVCI(routeOfAdministrationCode("IVCI"), "Infusion, intravenous catheter, intermittent"),
    PCA(routeOfAdministrationCode("PCA"), "Infusion, intravenous catheter, pca pump"),
    IVASCINFUS(routeOfAdministrationCode("IVASCINFUS"), "Infusion, intravascular"),
    IVASCINJ(routeOfAdministrationCode("IVASCINJ"), "Injection, intravascular"),
    IVENTINJ(routeOfAdministrationCode("IVENTINJ"), "Injection, intraventricular (heart)"),
    IVESINJ(routeOfAdministrationCode("IVESINJ"), "Injection, intravesicle"),
    IVFLUSH(routeOfAdministrationCode("IVFLUSH"), "Flush, intravenous catheter"),
    IVINJ(routeOfAdministrationCode("IVINJ"), "Injection, intravenous"),
    IVINJBOL(routeOfAdministrationCode("IVINJBOL"), "Injection, intravenous, bolus"),
    IVPUSH(routeOfAdministrationCode("IVPUSH"), "Injection, intravenous, push"),
    IVRPUSH(routeOfAdministrationCode("IVRPUSH"), "Injection, intravenous, rapid push"),
    IVSPUSH(routeOfAdministrationCode("IVSPUSH"), "Injection, intravenous, slow push"),
    IVITIMPLNT(routeOfAdministrationCode("IVITIMPLNT"), "Implantation, intravitreal"),
    IVITINJ(routeOfAdministrationCode("IVITINJ"), "Injection, intravitreal"),
    JJTINSTL(routeOfAdministrationCode("JJTINSTL"), "Instillation, jejunostomy tube"),
    LARYNGINSTIL(routeOfAdministrationCode("LARYNGINSTIL"), "Instillation, laryngeal"),
    LARYNGTA(routeOfAdministrationCode("LARYNGTA"), "Topical application, laryngeal"),
    LPINS(routeOfAdministrationCode("LPINS"), "Insertion, lacrimal puncta"),
    MUC(routeOfAdministrationCode("MUC"), "Topical application, mucous membrane"),
    NAIL(routeOfAdministrationCode("NAIL"), "Topical application, nail"),
    NASAL(routeOfAdministrationCode("NASAL"), "Topical application, nasal"),
    NASALINSTIL(routeOfAdministrationCode("NASALINSTIL"), "Instillation, nasal"),
    NASINHL(routeOfAdministrationCode("NASINHL"), "Inhalation, nasal"),
    NASINHLC(routeOfAdministrationCode("NASINHLC"), "Inhalation, nasal, prongs"),
    NP(routeOfAdministrationCode("NP"), "Inhalation, nasal, prongs"),
    NASOGASINSTIL(routeOfAdministrationCode("NASOGASINSTIL"), "Instillation, nasogastric"),
    NEB(routeOfAdministrationCode("NEB"), "Inhalation, nebulization"),
    NASNEB(routeOfAdministrationCode("NASNEB"), "Inhalation, nebulization, nasal"),
    ORNEB(routeOfAdministrationCode("ORNEB"), "Inhalation, nebulization, oral"),
    NGT(routeOfAdministrationCode("NGT"), "Instillation, nasogastric tube"),
    NTT(routeOfAdministrationCode("NTT"), "Instillation, nasotracheal tube"),
    OCDRESTA(routeOfAdministrationCode("OCDRESTA"), "Occlusive dressing technique"),
    OGT(routeOfAdministrationCode("OGT"), "Instillation, orogastric tube"),
    OJJ(routeOfAdministrationCode("OJJ"), "Instillation, orojejunum tube"),
    OPTHALTA(routeOfAdministrationCode("OPTHALTA"), "Topical application, ophthalmic"),
    ORALTA(routeOfAdministrationCode("ORALTA"), "Topical application, oral"),
    ORINHL(routeOfAdministrationCode("ORINHL"), "Inhalation, oral"),
    ORIFINHL(routeOfAdministrationCode("ORIFINHL"), "Inhalation, oral intermittent flow"),
    REBREATH(routeOfAdministrationCode("REBREATH"), "Inhalation, oral rebreather mask"),
    ORMUC(routeOfAdministrationCode("ORMUC"), "Topical application, oromucosal"),
    OROPHARTA(routeOfAdministrationCode("OROPHARTA"), "Topical application, oropharyngeal"),
    ORRINSE(routeOfAdministrationCode("ORRINSE"), "Rinse, oral"),
    OT(routeOfAdministrationCode("OT"), "Instillation, otic"),
    PAINJ(routeOfAdministrationCode("PAINJ"), "Injection, periarticular"),
    PARENTINJ(routeOfAdministrationCode("PARENTINJ"), "Injection, parenteral"),
    PDONTINJ(routeOfAdministrationCode("PDONTINJ"), "Injection, periodontal"),
    PDONTTA(routeOfAdministrationCode("PDONTTA"), "Topical application, periodontal"),
    PDPINJ(routeOfAdministrationCode("PDPINJ"), "Injection, peritoneal dialysis port"),
    PDPINSTL(routeOfAdministrationCode("PDPINSTL"), "Instillation, peritoneal dialysis port"),
    PDURINJ(routeOfAdministrationCode("PDURINJ"), "Injection, peridural"),
    PERIANAL(routeOfAdministrationCode("PERIANAL"), "Topical application, perianal"),
    PERINEAL(routeOfAdministrationCode("PERINEAL"), "Topical application, perineal"),
    PNINJ(routeOfAdministrationCode("PNINJ"), "Injection, perineural"),
    PNSINJ(routeOfAdministrationCode("PNSINJ"), "Injection, paranasal sinuses"),
    PNSINSTL(routeOfAdministrationCode("PNSINSTL"), "Instillation, paranasal sinuses"),
    PO(routeOfAdministrationCode("PO"), "Swallow, oral"),
    PR(routeOfAdministrationCode("PR"), "Insertion, rectal"),
    RBINJ(routeOfAdministrationCode("RBINJ"), "Injection, retrobulbar"),
    RECINSTL(routeOfAdministrationCode("RECINSTL"), "Instillation, rectal"),
    RECTINSTL(routeOfAdministrationCode("RECTINSTL"), "Instillation, rectal tube"),
    RECIRR(routeOfAdministrationCode("RECIRR"), "Irrigation, rectal"),
    RECTAL(routeOfAdministrationCode("RECTAL"), "Topical application, rectal"),
    RETENEMA(routeOfAdministrationCode("RETENEMA"), "Enema, rectal retention"),
    SCALP(routeOfAdministrationCode("SCALP"), "Topical application, scalp"),
    SCINJ(routeOfAdministrationCode("SCINJ"), "Injection, subconjunctival"),
    SHAMPOO(routeOfAdministrationCode("SHAMPOO"), "Shampoo"),
    SININSTIL(routeOfAdministrationCode("SININSTIL"), "Instillation, sinus, unspecified"),
    SKIN(routeOfAdministrationCode("SKIN"), "Topical application, skin"),
    SL(routeOfAdministrationCode("SL"), "Dissolve, sublingual"),
    SLESINJ(routeOfAdministrationCode("SLESINJ"), "Injection, sublesional"),
    SMUCMAB(routeOfAdministrationCode("SMUCMAB"), "Mucosal absorption, submucosal"),
    SOAK(routeOfAdministrationCode("SOAK"), "Immersion (soak)"),
    SOFTISINJ(routeOfAdministrationCode("SOFTISINJ"), "Injection, soft tissue"),
    SOFTISINSTIL(routeOfAdministrationCode("SOFTISINSTIL"), "Instillation, soft tissue"),
    SQ(routeOfAdministrationCode("SQ"), "Injection, subcutaneous"),
    SQIMPLNT(routeOfAdministrationCode("SQIMPLNT"), "Implantation, subcutaneous"),
    SQINFUS(routeOfAdministrationCode("SQINFUS"), "Infusion, subcutaneous"),
    SQSURGINS(routeOfAdministrationCode("SQSURGINS"), "Insertion, subcutaneous, surgical"),
    SUBARACHINJ(routeOfAdministrationCode("SUBARACHINJ"), "Injection, subarachnoid"),
    SUBCONJTA(routeOfAdministrationCode("SUBCONJTA"), "Subconjunctival"),
    SUBMUCINJ(routeOfAdministrationCode("SUBMUCINJ"), "Injection, submucosal"),
    SUCK(routeOfAdministrationCode("SUCK"), "Suck, oromucosal"),
    SWAB(routeOfAdministrationCode("SWAB"), "Topical application, swab"),
    SWISHSPIT(routeOfAdministrationCode("SWISHSPIT"), "Swish and spit out, oromucosal"),
    SWISHSWAL(routeOfAdministrationCode("SWISHSWAL"), "Swish and swallow, oromucosal"),
    TMUCTA(routeOfAdministrationCode("TMUCTA"), "Topical application, transmucosal"),
    TOPICAL(routeOfAdministrationCode("TOPICAL"), "Topical"),
    TRACH(routeOfAdministrationCode("TRACH"), "Inhalation, tracheostomy"),
    TRACHINSTL(routeOfAdministrationCode("TRACHINSTL"), "Instillation, tracheostomy"),
    TRNSDERM(routeOfAdministrationCode("TRNSDERM"), "Transdermal"),
    TRNSDERMD(routeOfAdministrationCode("TRNSDERMD"), "Diffusion, transdermal"),
    TRNSLING(routeOfAdministrationCode("TRNSLING"), "Translingual"),
    TRPLACINJ(routeOfAdministrationCode("TRPLACINJ"), "Injection, transplacental"),
    TRTRACHINJ(routeOfAdministrationCode("TRTRACHINJ"), "Injection, transtracheal"),
    TRTYMPINSTIL(routeOfAdministrationCode("TRTYMPINSTIL"), "Instillation, transtympanic"),
    TTYMPTABSORP(routeOfAdministrationCode("TTYMPTABSORP"), "Topical absorption, transtympanic"),
    URETHINJ(routeOfAdministrationCode("URETHINJ"), "Injection, urethral"),
    URETHINS(routeOfAdministrationCode("URETHINS"), "Insertion, urethral"),
    URETHINSTL(routeOfAdministrationCode("URETHINSTL"), "Instillation, urethral"),
    URETHSUP(routeOfAdministrationCode("URETHSUP"), "Suppository, urethral"),
    URETINJ(routeOfAdministrationCode("URETINJ"), "Injection, ureteral"),
    VAGINS(routeOfAdministrationCode("VAGINS"), "Insertion, vaginal"),
    VAGINSI(routeOfAdministrationCode("VAGINSI"), "Insertion, vaginal"),
    VENT(routeOfAdministrationCode("VENT"), "Inhalation, ventilator"),
    VENTMASK(routeOfAdministrationCode("VENTMASK"), "Inhalation, ventimask");

    public final RouteOfAdministrationCode code;

    public final String description;

    private RoutesOfAdministration(RouteOfAdministrationCode code, String description) {
        this.code = code;
        this.description = description;
    }
}
