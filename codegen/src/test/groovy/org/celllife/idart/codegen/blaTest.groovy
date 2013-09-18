package org.celllife.idart.codegen

import com.xlson.groovycsv.CsvParser
import org.junit.Test

/**
 * User: Kevin W. Sewell
 * Date: 2013-09-18
 * Time: 13h29
 */
class blaTest {


    def tsv = """Mnemonic\tConcept\tDescription
AMNINJ\tinjection, amniotic fluid\tInjection, amniotic fluid
BILINJ\tinjection, biliary tract\tInjection, biliary tract
BLADINJ\tinjection, urinary bladder\tInjection, urinary bladder
BLADINSTL\tinstillation, urinary catheter\tInstillation, urinary catheter
BLADIRR\tirrigation, urinary bladder\tIrrigation, urinary bladder
BLADIRRC\tirrigation, urinary bladder, continuous\tIrrigation, urinary bladder, continuous
BLADIRRT\tirrigation, urinary bladder, tidal\tIrrigation, urinary bladder, tidal
BUC\ttopical application, buccal\tTopical application, buccal
CAPDINSTL\tinstillation, continuous ambulatory peritoneal dialysis port\tInstillation, continuous ambulatory peritoneal dialysis port
CECINSTL\tinstillation, cecostomy\tInstillation, cecostomy
CERV\ttopical application, cervical\tTopical application, cervical
CERVINJ\tinjection, cervical\tInjection, cervical
CERVINS\tinsertion, cervical (uterine)\tInsertion, cervical (uterine)
CHEW\tchew, oral\tChew, oral
CHOLINJ\tinjection, for cholangiography\tInjection, for cholangiography
CTINSTL\tinstillation, chest tube\tInstillation, chest tube
DEN\ttopical application, dental\tTopical application, dental
DENRINSE\trinse, dental\tRinse, dental
DISSOLVE\tdissolve, oral\tDissolve, oral
DOUCHE\tdouche, vaginal\tDouche, vaginal
DRESS\ttopical application, soaked dressing\tTopical application, soaked dressing
EFT\tinstillation, enteral feeding tube\tInstillation, enteral feeding tube
ELECTOSMOS\telectro-osmosis\tElectro-osmosis
ENDOSININJ\tinjection, endosinusial\tInjection, endosinusial
ENEMA\tenema, rectal\tEnema, rectal
ENTINSTL\tinstillation, enteral\tInstillation, enteral
EPI\tinfusion, epidural\tInfusion, epidural
EPIDURINJ\tinjection, epidural\tInjection, epidural
EPIINJ\tinjection, epidural, push\tInjection, epidural, push
EPINJSP\tinjection, epidural, slow push\tInjection, epidural, slow push
ETINSTL\tinstillation, endotracheal tube\tInstillation, endotracheal tube
ETNEB\tnebulization, endotracheal tube\tNebulization, endotracheal tube
EXTCORPDIF\tdiffusion, extracorporeal\tDiffusion, extracorporeal
EXTCORPINJ\tinjection, extracorporeal\tInjection, extracorporeal
EXTRAMNINJ\tinjection, extra-amniotic\tInjection, extra-amniotic
GARGLE\tgargle\tGargle
GBINJ\tinjection, gastric button\tInjection, gastric button
GIN\ttopical application, gingival\tTopical application, gingival
GINGINJ\tinjection, gingival\tInjection, gingival
GJT\tinstillation, gastro-jejunostomy tube\tInstillation, gastro-jejunostomy tube
GT\tinstillation, gastrostomy tube\tInstillation, gastrostomy tube
GUIRR\tirrigation, genitourinary\tIrrigation, genitourinary
HAIR\ttopical application, hair\tTopical application, hair
HEMODIFF\tdiffusion, hemodialysis\tDiffusion, hemodialysis
HEMOPORT\tinjection, hemodialysis port\tInjection, hemodialysis port
IA\tinfusion, intraarterial catheter\tInfusion, intraarterial catheter
IABDINJ\tinjection, intra-abdominal\tInjection, intra-abdominal
IAINJ\tinjection, intraarterial\tInjection, intraarterial
IAINJP\tinjection, intraarterial, push\tInjection, intraarterial, push
IAINJSP\tinjection, intraarterial, slow push\tInjection, intraarterial, slow push
IARTINJ\tinjection, intraarticular\tInjection, intraarticular
IBRONCHINSTIL\tinstillation, intrabronchial\tInstillation, intrabronchial
IBURSINJ\tinjection, intrabursal\tInjection, intrabursal
IC\tinfusion, intracardiac\tInfusion, intracardiac
ICARDINJ\tinjection, intracardiac\tInjection, intracardiac
ICARDINJRP\tinjection, intracardiac, rapid push\tInjection, intracardiac, rapid push
ICARDINJSP\tinjection, intracardiac, slow push\tInjection, intracardiac, slow push
ICARINJP\tinjection, intracardiac, push\tInjection, intracardiac, push
ICARTINJ\tinjection, intracartilaginous\tInjection, intracartilaginous
ICAUDINJ\tinjection, intracaudal\tInjection, intracaudal
ICAVINJ\tinjection, intracavernous\tInjection, intracavernous
ICAVITINJ\tinjection, intracavitary\tInjection, intracavitary
ICEREBINJ\tinjection, intracerebral\tInjection, intracerebral
ICISTERNINJ\tinjection, intracisternal\tInjection, intracisternal
ICOR\tinfusion, intracoronary\tInfusion, intracoronary
ICORNTA\ttopical application, intracorneal\tTopical application, intracorneal
ICORONINJ\tinjection, intracoronary\tInjection, intracoronary
ICORONINJP\tinjection, intracoronary, push\tInjection, intracoronary, push
ICORONTA\ttopical application, intracoronal (dental)\tTopical application, intracoronal (dental)
ICORPCAVINJ\tinjection, intracorpus cavernosum\tInjection, intracorpus cavernosum
IDIMPLNT\timplantation, intradermal\tImplantation, intradermal
IDINJ\tinjection, intradermal\tInjection, intradermal
IDISCINJ\tinjection, intradiscal\tInjection, intradiscal
IDOUDMAB\tmucosal absorption, intraduodenal\tMucosal absorption, intraduodenal
IDUCTINJ\tinjection, intraductal\tInjection, intraductal
IDUODINSTIL\tinstillation, intraduodenal\tInstillation, intraduodenal
IDURINJ\tinjection, intradural\tInjection, intradural
IEPIDINJ\tinjection, intraepidermal\tInjection, intraepidermal
IEPITHINJ\tinjection, intraepithelial\tInjection, intraepithelial
IESOPHINSTIL\tinstillation, intraesophageal\tInstillation, intraesophageal
IESOPHTA\ttopical application, intraesophageal\tTopical application, intraesophageal
IGASTINSTIL\tinstillation, intragastric\tInstillation, intragastric
IGASTIRR\tirrigation, intragastric\tIrrigation, intragastric
IGASTLAV\tlavage, intragastric\tLavage, intragastric
IILEALINJ\tinstillation, intraileal\tInstillation, intraileal
IILEALTA\ttopical application, intraileal\tTopical application, intraileal
ILESINJ\tinjection, intralesional\tInjection, intralesional
ILESIRR\tirrigation, intralesional\tIrrigation, intralesional
ILTOP\ttopical application, intralesional\tTopical application, intralesional
ILUMINJ\tinjection, intraluminal\tInjection, intraluminal
ILUMTA\ttopical application, intraluminal\tTopical application, intraluminal
ILYMPJINJ\tinjection, intralymphatic\tInjection, intralymphatic
IM\tinjection, intramuscular\tInjection, intramuscular
IMD\tinjection, intramuscular, deep\tInjection, intramuscular, deep
IMZ\tinjection, intramuscular, z track\tInjection, intramuscular, z track
IMEDULINJ\tinjection, intramedullary\tInjection, intramedullary
INSUF\tinsufflation\tInsufflation
INTERMENINJ\tinjection, interameningeal\tInjection, interameningeal
INTERSTITINJ\tinjection, interstitial\tInjection, interstitial
IOINJ\tinjection, intraocular\tInjection, intraocular
IOINSTL\tinstillation, intraocular\tInstillation, intraocular
IOIRR\tirrigation, intraocular\tIrrigation, intraocular
IONTO\ttopical application, iontophoresis\tTopical application, iontophoresis
IOSSC\tinfusion, intraosseous, continuous\tInfusion, intraosseous, continuous
IOSSINJ\tinjection, intraosseous\tInjection, intraosseous
IOSURGINS\tinsertion, intraocular, surgical\tInsertion, intraocular, surgical
IOTOP\ttopical application, intraocular\tTopical application, intraocular
IOVARINJ\tinjection, intraovarian\tInjection, intraovarian
IPCARDINJ\tinjection, intrapericardial\tInjection, intrapericardial
IPERINJ\tinjection, intraperitoneal\tInjection, intraperitoneal
IPINJ\tinjection, intrapulmonary\tInjection, intrapulmonary
IPLRINJ\tinjection, intrapleural\tInjection, intrapleural
IPPB\tinhalation, intermittent positive pressure breathing (ippb)\tInhalation, intermittent positive pressure breathing (ippb)
IPROSTINJ\tinjection, intraprostatic\tInjection, intraprostatic
IPUMPINJ\tinjection, insulin pump\tInjection, insulin pump
ISININSTIL\tinstillation, intrasinal\tInstillation, intrasinal
ISINJ\tinjection, intraspinal\tInjection, intraspinal
ISTERINJ\tinjection, intrasternal\tInjection, intrasternal
ISYNINJ\tinjection, intrasynovial\tInjection, intrasynovial
IT\tinfusion, intrathecal\tInfusion, intrathecal
ITENDINJ\tinjection, intratendinous\tInjection, intratendinous
ITESTINJ\tinjection, intratesticular\tInjection, intratesticular
ITHORINJ\tinjection, intrathoracic\tInjection, intrathoracic
ITINJ\tinjection, intrathecal\tInjection, intrathecal
ITRACHINSTIL\tinstillation, intratracheal\tInstillation, intratracheal
ITRACHMAB\tmucosal absorption, intratracheal\tMucosal absorption, intratracheal
ITUBINJ\tinjection, intratubular\tInjection, intratubular
ITUMINJ\tinjection, intratumor\tInjection, intratumor
ITYMPINJ\tinjection, intratympanic\tInjection, intratympanic
IU\tinsertion, intrauterine\tInsertion, intrauterine
IUINJ\tinjection, intrauterine\tInjection, intracervical (uterus)
IUINJC\tinjection, intracervical (uterus)\tInjection, intracervical (uterus)
IUINSTL\tinstillation, intrauterine\tInstillation, intrauterine
IURETINJ\tinjection, intraureteral, retrograde\tInjection, intraureteral, retrograde
IV\tinfusion, intravenous\tInfusion, intravenous
IVC\tinfusion, intravenous catheter\tInfusion, intravenous catheter
IVCC\tinfusion, intravenous catheter, continuous\tInfusion, intravenous catheter, continuous
IVCI\tinfusion, intravenous catheter, intermittent\tInfusion, intravenous catheter, intermittent
PCA\tinfusion, intravenous catheter, pca pump\tInfusion, intravenous catheter, pca pump
IVASCINFUS\tinfusion, intravascular\tInfusion, intravascular
IVASCINJ\tinjection, intravascular\tInjection, intravascular
IVENTINJ\tinjection, intraventricular (heart)\tInjection, intraventricular (heart)
IVESINJ\tinjection, intravesicle\tInjection, intravesicle
IVFLUSH\tflush, intravenous catheter\tFlush, intravenous catheter
IVINJ\tinjection, intravenous\tInjection, intravenous
IVINJBOL\tinjection, intravenous, bolus\tInjection, intravenous, bolus
IVPUSH\tinjection, intravenous, push\tInjection, intravenous, push
IVRPUSH\tinjection, intravenous, rapid push\tInjection, intravenous, rapid push
IVSPUSH\tinjection, intravenous, slow push\tInjection, intravenous, slow push
IVITIMPLNT\timplantation, intravitreal\tImplantation, intravitreal
IVITINJ\tinjection, intravitreal\tInjection, intravitreal
JJTINSTL\tinstillation, jejunostomy tube\tInstillation, jejunostomy tube
LARYNGINSTIL\tinstillation, laryngeal\tInstillation, laryngeal
LARYNGTA\ttopical application, laryngeal\tTopical application, laryngeal
LPINS\tinsertion, lacrimal puncta\tInsertion, lacrimal puncta
MUC\ttopical application, mucous membrane\tTopical application, mucous membrane
NAIL\ttopical application, nail\tTopical application, nail
NASAL\ttopical application, nasal\tTopical application, nasal
NASALINSTIL\tinstillation, nasal\tInstillation, nasal
NASINHL\tinhalation, nasal\tInhalation, nasal
NASINHLC\tinhalation, nasal cannula\tInhalation, nasal, prongs
NP\tinhalation, nasal cannula\tInhalation, nasal, prongs
NASOGASINSTIL\tinstillation, nasogastric\tInstillation, nasogastric
NEB\tinhalation, nebulization\tInhalation, nebulization
NASNEB\tinhalation, nebulization, nasal\tInhalation, nebulization, nasal
ORNEB\tinhalation, nebulization, oral\tInhalation, nebulization, oral
NGT\tinstillation, nasogastric tube\tInstillation, nasogastric tube
NTT\tinstillation, nasotracheal tube\tInstillation, nasotracheal tube
OCDRESTA\tocclusive dressing technique\tOcclusive dressing technique
OGT\tinstillation, orogastric tube\tInstillation, orogastric tube
OJJ\tinstillation, orojejunum tube\tInstillation, orojejunum tube
OPTHALTA\ttopical application, ophthalmic\tTopical application, ophthalmic
ORALTA\ttopical application, oral\tTopical application, oral
ORINHL\tinhalation, respiratory\tInhalation, oral
ORIFINHL\tinhalation, oral intermittent flow\tInhalation, oral intermittent flow
REBREATH\tinhalation, oral rebreather mask\tInhalation, oral rebreather mask
ORMUC\ttopical application, oromucosal\tTopical application, oromucosal
OROPHARTA\ttopical application, oropharyngeal\tTopical application, oropharyngeal
ORRINSE\tinse, oral\tRinse, oral
OT\tinstillation, otic\tInstillation, otic
PAINJ\tinjection, periarticular\tInjection, periarticular
PARENTINJ\tinjection, parenteral\tInjection, parenteral
PDONTINJ\tinjection, periodontal\tInjection, periodontal
PDONTTA\ttopical application, periodontal\tTopical application, periodontal
PDPINJ\tinjection, peritoneal dialysis port\tInjection, peritoneal dialysis port
PDPINSTL\tinstillation, peritoneal dialysis port\tInstillation, peritoneal dialysis port
PDURINJ\tinjection, peridural\tInjection, peridural
PERIANAL\ttopical application, perianal\tTopical application, perianal
PERINEAL\ttopical application, perineal\tTopical application, perineal
PNINJ\tinjection, perineural\tInjection, perineural
PNSINJ\tinjection, paranasal sinuses\tInjection, paranasal sinuses
PNSINSTL\tinstillation, paranasal sinuses\tInstillation, paranasal sinuses
PO\tswallow, oral\tSwallow, oral
PR\tinsertion, rectal\tInsertion, rectal
RBINJ\tinjection, retrobulbar\tInjection, retrobulbar
RECINSTL\tinstillation, rectal\tInstillation, rectal
RECTINSTL\tinstillation, rectal tube\tInstillation, rectal tube
RECIRR\tirrigation, rectal\tIrrigation, rectal
RECTAL\ttopical application, rectal\tTopical application, rectal
RETENEMA\tenema, rectal retention\tEnema, rectal retention
SCALP\ttopical application, scalp\tTopical application, scalp
SCINJ\tinjection, subconjunctival\tInjection, subconjunctival
SHAMPOO\tshampoo\tShampoo
SININSTIL\tinstillation, sinus, unspecified\tInstillation, sinus, unspecified
SKIN\ttopical application, skin\tTopical application, skin
SL\tdissolve, sublingual\tDissolve, sublingual
SLESINJ\tinjection, sublesional\tInjection, sublesional
SMUCMAB\tmucosal absorption, submucosal\tMucosal absorption, submucosal
SOAK\timmersion (soak)\tImmersion (soak)
SOFTISINJ\tinjection, soft tissue\tInjection, soft tissue
SOFTISINSTIL\tinstillation, soft tissue\tInstillation, soft tissue
SQ\tinjection, subcutaneous\tInjection, subcutaneous
SQIMPLNT\timplantation, subcutaneous\tImplantation, subcutaneous
SQINFUS\tinfusion, subcutaneous\tInfusion, subcutaneous
SQSURGINS\tinsertion, subcutaneous, surgical\tInsertion, subcutaneous, surgical
SUBARACHINJ\tinjection, subarachnoid\tInjection, subarachnoid
SUBCONJTA\tsubconjunctival\tSubconjunctival
SUBMUCINJ\tinjection, submucosal\tInjection, submucosal
SUCK\tsuck, oromucosal\tSuck, oromucosal
SWAB\ttopical application, swab\tTopical application, swab
SWISHSPIT\tswish and spit out, oromucosal\tSwish and spit out, oromucosal
SWISHSWAL\tswish and swallow, oromucosal\tSwish and swallow, oromucosal
TMUCTA\ttopical application, transmucosal\tTopical application, transmucosal
TOPICAL\ttopical\tTopical
TRACH\tinhalation, tracheostomy\tInhalation, tracheostomy
TRACHINSTL\tinstillation, tracheostomy\tInstillation, tracheostomy
TRNSDERM\ttransdermal\tTransdermal
TRNSDERMD\tdiffusion, transdermal\tDiffusion, transdermal
TRNSLING\ttranslingual\tTranslingual
TRPLACINJ\tinjection, transplacental\tInjection, transplacental
TRTRACHINJ\tinjection, transtracheal\tInjection, transtracheal
TRTYMPINSTIL\tinstillation, transtympanic\tInstillation, transtympanic
TTYMPTABSORP\ttopical absorption, transtympanic\tTopical absorption, transtympanic
URETHINJ\tinjection, urethral\tInjection, urethral
URETHINS\tinsertion, urethral\tInsertion, urethral
URETHINSTL\tinstillation, urethral\tInstillation, urethral
URETHSUP\tsuppository, urethral\tSuppository, urethral
URETINJ\tinjection, ureteral\tInjection, ureteral
VAGINS\ttopical application, vaginal\tInsertion, vaginal
VAGINSI\tinsertion, vaginal\tInsertion, vaginal
VENT\tinhalation, ventilator\tInhalation, ventilator
VENTMASK\tinhalation, ventimask\tInhalation, ventimask"""

    @Test
    public void testName() throws Exception {

        CsvParser.parseCsv([separator:"\t", quoteChar:""], tsv).each { row ->
            println "${row.Mnemonic}(routeOfAdministrationCode(\"${row.Mnemonic}\"), \"${row.Description}\"),"
        }

    }
}
