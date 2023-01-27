import sc.analysis.*;
import sc.node.*;
import sa.*;
import util.Type;

public class Sc2sa extends DepthFirstAdapter {
    private SaNode returnValue;
    private Type returnType;

    public void defaultIn(@SuppressWarnings("unused") Node node) {
        //System.out.println("<" + node.getClass().getSimpleName() + ">");
    }

    public void defaultOut(@SuppressWarnings("unused") Node node) {
        //System.out.println("</" + node.getClass().getSimpleName() + ">");
    }

    public SaNode getRoot() {
        return this.returnValue;
    }

    public void inStart(Start node) {
        defaultIn(node);
    }

    public void outStart(Start node) {
        defaultOut(node);
    }

    public void inAProgramme(AProgramme node) {
        defaultIn(node);
    }

    public void outAProgramme(AProgramme node) {
        defaultOut(node);
    }



    //exp4 = {plus} exp4 plus exp5
    @Override
    public void caseAPlusExp4(APlusExp4 node) {
        SaExp op1 = null;
        SaExp op2 = null;
        inAPlusExp4(node);
        if (node.getExp4() != null) {
            node.getExp4().apply(this);
            op1 = (SaExp) this.returnValue;
        }
        if (node.getExp5() != null) {
            node.getExp5().apply(this);
            op2 = (SaExp) this.returnValue;

        }
        this.returnValue = new SaExpAdd(op1, op2);
        outAPlusExp4(node);
    }



    @Override
    public void caseStart(Start node) {
        inStart(node);
        node.getPProgramme().apply(this);
        node.getEOF().apply(this);
        outStart(node);
    }


    //programme = listedecvar listedecfonc ;
    @Override
    public void caseAProgramme(AProgramme node) {
        inAProgramme(node);
        SaLDecVar LdecVar = null;
        SaLDecFonc  LdecFonc = null;
        if (node.getListedecvar() != null) {
            node.getListedecvar().apply(this);
            LdecFonc = (SaLDecFonc) this.returnValue;
        }
        if (node.getListedecfonc() != null) {
            node.getListedecfonc().apply(this);
            LdecVar = (SaLDecVar) this.returnValue;

        }
        this.returnValue = new SaProg(LdecVar,LdecFonc);

        outAProgramme(node);
    }

    public void inADecvarListedecvar(ADecvarListedecvar node) {
        defaultIn(node);
    }

    public void outADecvarListedecvar(ADecvarListedecvar node) {
        defaultOut(node);
    }



    //listedecvar = {decvar} decvar listedecvarbis
    @Override
    public void caseADecvarListedecvar(ADecvarListedecvar node) {
        inADecvarListedecvar(node);
        SaDecVar decVar= null;
        SaLDecVar ldecVar = null;
        if (node.getDecvar() != null) {
            node.getDecvar().apply(this);
            decVar = (SaDecVar) this.returnValue;
        }
        if (node.getListedecvarbis() != null) {
            node.getListedecvarbis().apply(this);
            ldecVar = (SaLDecVar) this.returnValue;
        }
        this.returnValue = new SaLDecVar(decVar,ldecVar);
        outADecvarListedecvar(node);
    }


    public void inAVideListedecvar(AVideListedecvar node) {
        defaultIn(node);
    }

    public void outAVideListedecvar(AVideListedecvar node) {
        defaultOut(node);
    }

    @Override
    public void caseAVideListedecvar(AVideListedecvar node) {
        inAVideListedecvar(node);
        outAVideListedecvar(node);
    }


    //listedecvarbis = {listdecvar} virgule decvar listedecvarbis
    @Override
    public void caseAListdecvarListedecvarbis(AListdecvarListedecvarbis node) {
        inAListdecvarListedecvarbis(node);
        SaDecVar decVar = null;
        SaLDecVar lDecVar = null;

        if (node.getDecvar() != null) {
            node.getDecvar().apply(this);
            decVar = (SaDecVar) this.returnValue;
        }
        if (node.getListedecvarbis() != null) {
            node.getListedecvarbis().apply(this);
            lDecVar = (SaLDecVar) this.returnValue;
        }
        this.returnValue = new SaLDecVar(decVar,lDecVar);
        outAListdecvarListedecvarbis(node);
    }

    public void inAListdecvarListedecvarbis(AListdecvarListedecvarbis node) {
        defaultIn(node);
    }

    public void outAListdecvarListedecvarbis(AListdecvarListedecvarbis node) {
        defaultOut(node);
    }










    public void inAVideListedecvarbis(AVideListedecvarbis node) {
        defaultIn(node);
    }

    public void outAVideListedecvarbis(AVideListedecvarbis node) {
        defaultOut(node);
    }

    @Override
    public void caseAVideListedecvarbis(AVideListedecvarbis node) {
        inAVideListedecvarbis(node);
        outAVideListedecvarbis(node);
    }

    public void inAVarDecvar(AVarDecvar node) {
        defaultIn(node);
    }

    public void outAVarDecvar(AVarDecvar node) {
        defaultOut(node);
    }

    @Override
    public void caseAVarDecvar(AVarDecvar node) {
        inAVarDecvar(node);
        if (node.getTypevar() != null) {
            node.getTypevar().apply(this);
        }
        if (node.getId() != null) {
            node.getId().apply(this);
        }
        outAVarDecvar(node);
    }

    public void inAFoncDecvar(AFoncDecvar node) {
        defaultIn(node);
    }

    public void outAFoncDecvar(AFoncDecvar node) {
        defaultOut(node);
    }

    @Override
    public void caseAFoncDecvar(AFoncDecvar node) {
        inAFoncDecvar(node);
        if (node.getTypevar() != null) {
            node.getTypevar().apply(this);
        }
        if (node.getId() != null) {
            node.getId().apply(this);
        }
        if (node.getCo() != null) {
            node.getCo().apply(this);
        }
        if (node.getNombre() != null) {
            node.getNombre().apply(this);
        }
        if (node.getCf() != null) {
            node.getCf().apply(this);
        }
        outAFoncDecvar(node);
    }

    public void inABooleanTypevar(ABooleanTypevar node) {
        defaultIn(node);
    }

    public void outABooleanTypevar(ABooleanTypevar node) {
        defaultOut(node);
    }

    @Override
    public void caseABooleanTypevar(ABooleanTypevar node) {
        inABooleanTypevar(node);
        if (node.getBoolean() != null) {
            node.getBoolean().apply(this);
        }
        outABooleanTypevar(node);
    }

    public void inAEntierTypevar(AEntierTypevar node) {
        defaultIn(node);
    }

    public void outAEntierTypevar(AEntierTypevar node) {
        defaultOut(node);
    }

    @Override
    public void caseAEntierTypevar(AEntierTypevar node) {
        inAEntierTypevar(node);
        if (node.getEntier() != null) {
            node.getEntier().apply(this);
        }
        outAEntierTypevar(node);
    }

    public void inADecfoncListedecfonc(ADecfoncListedecfonc node) {
        defaultIn(node);
    }

    public void outADecfoncListedecfonc(ADecfoncListedecfonc node) {
        defaultOut(node);
    }

    @Override
    public void caseADecfoncListedecfonc(ADecfoncListedecfonc node) {
        inADecfoncListedecfonc(node);
        if (node.getDecfonc() != null) {
            node.getDecfonc().apply(this);
        }
        if (node.getListedecfonc() != null) {
            node.getListedecfonc().apply(this);
        }
        outADecfoncListedecfonc(node);
    }

    public void inAVideListedecfonc(AVideListedecfonc node) {
        defaultIn(node);
    }

    public void outAVideListedecfonc(AVideListedecfonc node) {
        defaultOut(node);
    }

    @Override
    public void caseAVideListedecfonc(AVideListedecfonc node) {
        inAVideListedecfonc(node);
        outAVideListedecfonc(node);
    }

    public void inADecfonc(ADecfonc node) {
        defaultIn(node);
    }

    public void outADecfonc(ADecfonc node) {
        defaultOut(node);
    }

    @Override
    public void caseADecfonc(ADecfonc node) {
        inADecfonc(node);
        if (node.getTypeop() != null) {
            node.getTypeop().apply(this);
        }
        if (node.getId() != null) {
            node.getId().apply(this);
        }
        if (node.getPo() != null) {
            node.getPo().apply(this);
        }
        if (node.getPremier() != null) {
            node.getPremier().apply(this);
        }
        if (node.getPf() != null) {
            node.getPf().apply(this);
        }
        if (node.getSecond() != null) {
            node.getSecond().apply(this);
        }
        if (node.getBlocinst() != null) {
            node.getBlocinst().apply(this);
        }
        outADecfonc(node);
    }

    public void inATypeopTypeop(ATypeopTypeop node) {
        defaultIn(node);
    }

    public void outATypeopTypeop(ATypeopTypeop node) {
        defaultOut(node);
    }

    @Override
    public void caseATypeopTypeop(ATypeopTypeop node) {
        inATypeopTypeop(node);
        if (node.getTypevar() != null) {
            node.getTypevar().apply(this);
        }
        outATypeopTypeop(node);
    }

    public void inAVideTypeop(AVideTypeop node) {
        defaultIn(node);
    }

    public void outAVideTypeop(AVideTypeop node) {
        defaultOut(node);
    }

    @Override
    public void caseAVideTypeop(AVideTypeop node) {
        inAVideTypeop(node);
        outAVideTypeop(node);
    }

    public void inABlocinst(ABlocinst node) {
        defaultIn(node);
    }

    public void outABlocinst(ABlocinst node) {
        defaultOut(node);
    }

    @Override
    public void caseABlocinst(ABlocinst node) {
        inABlocinst(node);
        if (node.getAco() != null) {
            node.getAco().apply(this);
        }
        if (node.getListeinst() != null) {
            node.getListeinst().apply(this);
        }
        if (node.getAcf() != null) {
            node.getAcf().apply(this);
        }
        outABlocinst(node);
    }

    public void inAListinstListeinst(AListinstListeinst node) {
        defaultIn(node);
    }

    public void outAListinstListeinst(AListinstListeinst node) {
        defaultOut(node);
    }

    @Override
    public void caseAListinstListeinst(AListinstListeinst node) {
        inAListinstListeinst(node);
        if (node.getInst() != null) {
            node.getInst().apply(this);
        }
        if (node.getListeinst() != null) {
            node.getListeinst().apply(this);
        }
        outAListinstListeinst(node);
    }

    public void inAVideListeinst(AVideListeinst node) {
        defaultIn(node);
    }

    public void outAVideListeinst(AVideListeinst node) {
        defaultOut(node);
    }

    @Override
    public void caseAVideListeinst(AVideListeinst node) {
        inAVideListeinst(node);
        outAVideListeinst(node);
    }

    public void inAInstInst(AInstInst node) {
        defaultIn(node);
    }

    public void outAInstInst(AInstInst node) {
        defaultOut(node);
    }

    @Override
    public void caseAInstInst(AInstInst node) {
        inAInstInst(node);
        if (node.getVar() != null) {
            node.getVar().apply(this);
        }
        if (node.getEgale() != null) {
            node.getEgale().apply(this);
        }
        if (node.getExp() != null) {
            node.getExp().apply(this);
        }
        if (node.getPvirgule() != null) {
            node.getPvirgule().apply(this);
        }
        outAInstInst(node);
    }

    public void inATanqueInst(ATanqueInst node) {
        defaultIn(node);
    }

    public void outATanqueInst(ATanqueInst node) {
        defaultOut(node);
    }

    @Override
    public void caseATanqueInst(ATanqueInst node) {
        inATanqueInst(node);
        if (node.getTantque() != null) {
            node.getTantque().apply(this);
        }
        if (node.getExp() != null) {
            node.getExp().apply(this);
        }
        if (node.getFaire() != null) {
            node.getFaire().apply(this);
        }
        if (node.getBlocinst() != null) {
            node.getBlocinst().apply(this);
        }
        outATanqueInst(node);
    }

    public void inASiInst(ASiInst node) {
        defaultIn(node);
    }

    public void outASiInst(ASiInst node) {
        defaultOut(node);
    }

    @Override
    public void caseASiInst(ASiInst node) {
        inASiInst(node);
        if (node.getSi() != null) {
            node.getSi().apply(this);
        }
        if (node.getExp() != null) {
            node.getExp().apply(this);
        }
        if (node.getAlors() != null) {
            node.getAlors().apply(this);
        }
        if (node.getBlocinst() != null) {
            node.getBlocinst().apply(this);
        }
        outASiInst(node);
    }

    public void inASisinonInst(ASisinonInst node) {
        defaultIn(node);
    }

    public void outASisinonInst(ASisinonInst node) {
        defaultOut(node);
    }

    @Override
    public void caseASisinonInst(ASisinonInst node) {
        inASisinonInst(node);
        if (node.getSi() != null) {
            node.getSi().apply(this);
        }
        if (node.getExp() != null) {
            node.getExp().apply(this);
        }
        if (node.getAlors() != null) {
            node.getAlors().apply(this);
        }
        if (node.getPremier() != null) {
            node.getPremier().apply(this);
        }
        if (node.getSinon() != null) {
            node.getSinon().apply(this);
        }
        if (node.getSecond() != null) {
            node.getSecond().apply(this);
        }
        outASisinonInst(node);
    }

    public void inARetournInst(ARetournInst node) {
        defaultIn(node);
    }

    public void outARetournInst(ARetournInst node) {
        defaultOut(node);
    }

    @Override
    public void caseARetournInst(ARetournInst node) {
        inARetournInst(node);
        if (node.getRetourne() != null) {
            node.getRetourne().apply(this);
        }
        if (node.getExp() != null) {
            node.getExp().apply(this);
        }
        if (node.getPvirgule() != null) {
            node.getPvirgule().apply(this);
        }
        outARetournInst(node);
    }

    public void inAAppfoncInst(AAppfoncInst node) {
        defaultIn(node);
    }

    public void outAAppfoncInst(AAppfoncInst node) {
        defaultOut(node);
    }

    @Override
    public void caseAAppfoncInst(AAppfoncInst node) {
        inAAppfoncInst(node);
        if (node.getId() != null) {
            node.getId().apply(this);
        }
        if (node.getPo() != null) {
            node.getPo().apply(this);
        }
        if (node.getListeexp() != null) {
            node.getListeexp().apply(this);
        }
        if (node.getPf() != null) {
            node.getPf().apply(this);
        }
        if (node.getPvirgule() != null) {
            node.getPvirgule().apply(this);
        }
        outAAppfoncInst(node);
    }

    public void inAEcrireInst(AEcrireInst node) {
        defaultIn(node);
    }

    public void outAEcrireInst(AEcrireInst node) {
        defaultOut(node);
    }

    @Override
    public void caseAEcrireInst(AEcrireInst node) {
        inAEcrireInst(node);
        if (node.getEcrire() != null) {
            node.getEcrire().apply(this);
        }
        if (node.getPo() != null) {
            node.getPo().apply(this);
        }
        if (node.getExp() != null) {
            node.getExp().apply(this);
        }
        if (node.getPf() != null) {
            node.getPf().apply(this);
        }
        if (node.getPvirgule() != null) {
            node.getPvirgule().apply(this);
        }
        outAEcrireInst(node);
    }

    public void inAListexpListeexp(AListexpListeexp node) {
        defaultIn(node);
    }

    public void outAListexpListeexp(AListexpListeexp node) {
        defaultOut(node);
    }

    @Override
    public void caseAListexpListeexp(AListexpListeexp node) {
        inAListexpListeexp(node);
        if (node.getExp() != null) {
            node.getExp().apply(this);
        }
        if (node.getListeexpbis() != null) {
            node.getListeexpbis().apply(this);
        }
        outAListexpListeexp(node);
    }

    public void inAVideListeexp(AVideListeexp node) {
        defaultIn(node);
    }

    public void outAVideListeexp(AVideListeexp node) {
        defaultOut(node);
    }

    @Override
    public void caseAVideListeexp(AVideListeexp node) {
        inAVideListeexp(node);
        outAVideListeexp(node);
    }

    public void inAListexpbisListeexpbis(AListexpbisListeexpbis node) {
        defaultIn(node);
    }

    public void outAListexpbisListeexpbis(AListexpbisListeexpbis node) {
        defaultOut(node);
    }

    @Override
    public void caseAListexpbisListeexpbis(AListexpbisListeexpbis node) {
        inAListexpbisListeexpbis(node);
        if (node.getVirgule() != null) {
            node.getVirgule().apply(this);
        }
        if (node.getExp() != null) {
            node.getExp().apply(this);
        }
        if (node.getListeexpbis() != null) {
            node.getListeexpbis().apply(this);
        }
        outAListexpbisListeexpbis(node);
    }

    public void inAVideListeexpbis(AVideListeexpbis node) {
        defaultIn(node);
    }

    public void outAVideListeexpbis(AVideListeexpbis node) {
        defaultOut(node);
    }

    @Override
    public void caseAVideListeexpbis(AVideListeexpbis node) {
        inAVideListeexpbis(node);
        outAVideListeexpbis(node);
    }

    public void inAOuExp(AOuExp node) {
        defaultIn(node);
    }

    public void outAOuExp(AOuExp node) {
        defaultOut(node);
    }

    @Override
    public void caseAOuExp(AOuExp node) {
        inAOuExp(node);
        if (node.getExp() != null) {
            node.getExp().apply(this);
        }
        if (node.getOu() != null) {
            node.getOu().apply(this);
        }
        if (node.getExp2() != null) {
            node.getExp2().apply(this);
        }
        outAOuExp(node);
    }

    public void inAExp2Exp(AExp2Exp node) {
        defaultIn(node);
    }

    public void outAExp2Exp(AExp2Exp node) {
        defaultOut(node);
    }

    @Override
    public void caseAExp2Exp(AExp2Exp node) {
        inAExp2Exp(node);
        if (node.getExp2() != null) {
            node.getExp2().apply(this);
        }
        outAExp2Exp(node);
    }

    public void inAEtExp2(AEtExp2 node) {
        defaultIn(node);
    }

    public void outAEtExp2(AEtExp2 node) {
        defaultOut(node);
    }

    @Override
    public void caseAEtExp2(AEtExp2 node) {
        inAEtExp2(node);
        if (node.getExp2() != null) {
            node.getExp2().apply(this);
        }
        if (node.getEt() != null) {
            node.getEt().apply(this);
        }
        if (node.getExp3() != null) {
            node.getExp3().apply(this);
        }
        outAEtExp2(node);
    }

    public void inAExp3Exp2(AExp3Exp2 node) {
        defaultIn(node);
    }

    public void outAExp3Exp2(AExp3Exp2 node) {
        defaultOut(node);
    }

    @Override
    public void caseAExp3Exp2(AExp3Exp2 node) {
        inAExp3Exp2(node);
        if (node.getExp3() != null) {
            node.getExp3().apply(this);
        }
        outAExp3Exp2(node);
    }

    public void inAEgaleExp3(AEgaleExp3 node) {
        defaultIn(node);
    }

    public void outAEgaleExp3(AEgaleExp3 node) {
        defaultOut(node);
    }

    @Override
    public void caseAEgaleExp3(AEgaleExp3 node) {
        inAEgaleExp3(node);
        if (node.getExp3() != null) {
            node.getExp3().apply(this);
        }
        if (node.getEgale() != null) {
            node.getEgale().apply(this);
        }
        if (node.getExp4() != null) {
            node.getExp4().apply(this);
        }
        outAEgaleExp3(node);
    }

    public void inAInfExp3(AInfExp3 node) {
        defaultIn(node);
    }

    public void outAInfExp3(AInfExp3 node) {
        defaultOut(node);
    }

    @Override
    public void caseAInfExp3(AInfExp3 node) {
        inAInfExp3(node);
        if (node.getExp3() != null) {
            node.getExp3().apply(this);
        }
        if (node.getInf() != null) {
            node.getInf().apply(this);
        }
        if (node.getExp4() != null) {
            node.getExp4().apply(this);
        }
        outAInfExp3(node);
    }

    public void inAExp4Exp3(AExp4Exp3 node) {
        defaultIn(node);
    }

    public void outAExp4Exp3(AExp4Exp3 node) {
        defaultOut(node);
    }

    @Override
    public void caseAExp4Exp3(AExp4Exp3 node) {
        inAExp4Exp3(node);
        if (node.getExp4() != null) {
            node.getExp4().apply(this);
        }
        outAExp4Exp3(node);
    }

    public void inAPlusExp4(APlusExp4 node) {
        defaultIn(node);
    }

    public void outAPlusExp4(APlusExp4 node) {
        defaultOut(node);
    }


    public void inAMoinsExp4(AMoinsExp4 node) {
        defaultIn(node);
    }

    public void outAMoinsExp4(AMoinsExp4 node) {
        defaultOut(node);
    }

    @Override
    public void caseAMoinsExp4(AMoinsExp4 node) {
        inAMoinsExp4(node);
        if (node.getExp4() != null) {
            node.getExp4().apply(this);
        }
        if (node.getMoins() != null) {
            node.getMoins().apply(this);
        }
        if (node.getExp5() != null) {
            node.getExp5().apply(this);
        }
        outAMoinsExp4(node);
    }

    public void inAExp5Exp4(AExp5Exp4 node) {
        defaultIn(node);
    }

    public void outAExp5Exp4(AExp5Exp4 node) {
        defaultOut(node);
    }

    @Override
    public void caseAExp5Exp4(AExp5Exp4 node) {
        inAExp5Exp4(node);
        if (node.getExp5() != null) {
            node.getExp5().apply(this);
        }
        outAExp5Exp4(node);
    }

    public void inADivExp5(ADivExp5 node) {
        defaultIn(node);
    }

    public void outADivExp5(ADivExp5 node) {
        defaultOut(node);
    }

    @Override
    public void caseADivExp5(ADivExp5 node) {
        inADivExp5(node);
        if (node.getExp5() != null) {
            node.getExp5().apply(this);
        }
        if (node.getDiv() != null) {
            node.getDiv().apply(this);
        }
        if (node.getExp6() != null) {
            node.getExp6().apply(this);
        }
        outADivExp5(node);
    }

    public void inAMultExp5(AMultExp5 node) {
        defaultIn(node);
    }

    public void outAMultExp5(AMultExp5 node) {
        defaultOut(node);
    }

    @Override
    public void caseAMultExp5(AMultExp5 node) {
        inAMultExp5(node);
        if (node.getExp5() != null) {
            node.getExp5().apply(this);
        }
        if (node.getMult() != null) {
            node.getMult().apply(this);
        }
        if (node.getExp6() != null) {
            node.getExp6().apply(this);
        }
        outAMultExp5(node);
    }

    public void inAExp6Exp5(AExp6Exp5 node) {
        defaultIn(node);
    }

    public void outAExp6Exp5(AExp6Exp5 node) {
        defaultOut(node);
    }

    @Override
    public void caseAExp6Exp5(AExp6Exp5 node) {
        inAExp6Exp5(node);
        if (node.getExp6() != null) {
            node.getExp6().apply(this);
        }
        outAExp6Exp5(node);
    }

    public void inANonExp6(ANonExp6 node) {
        defaultIn(node);
    }

    public void outANonExp6(ANonExp6 node) {
        defaultOut(node);
    }

    @Override
    public void caseANonExp6(ANonExp6 node) {
        inANonExp6(node);
        if (node.getNon() != null) {
            node.getNon().apply(this);
        }
        if (node.getExp6() != null) {
            node.getExp6().apply(this);
        }
        outANonExp6(node);
    }

    public void inAExp7Exp6(AExp7Exp6 node) {
        defaultIn(node);
    }

    public void outAExp7Exp6(AExp7Exp6 node) {
        defaultOut(node);
    }

    @Override
    public void caseAExp7Exp6(AExp7Exp6 node) {
        inAExp7Exp6(node);
        if (node.getExp7() != null) {
            node.getExp7().apply(this);
        }
        outAExp7Exp6(node);
    }

    public void inAExpbExp7(AExpbExp7 node) {
        defaultIn(node);
    }

    public void outAExpbExp7(AExpbExp7 node) {
        defaultOut(node);
    }

    @Override
    public void caseAExpbExp7(AExpbExp7 node) {
        inAExpbExp7(node);
        if (node.getPo() != null) {
            node.getPo().apply(this);
        }
        if (node.getExp() != null) {
            node.getExp().apply(this);
        }
        if (node.getPf() != null) {
            node.getPf().apply(this);
        }
        outAExpbExp7(node);
    }

    public void inAVarExp7(AVarExp7 node) {
        defaultIn(node);
    }

    public void outAVarExp7(AVarExp7 node) {
        defaultOut(node);
    }

    @Override
    public void caseAVarExp7(AVarExp7 node) {
        inAVarExp7(node);
        if (node.getVar() != null) {
            node.getVar().apply(this);
        }
        outAVarExp7(node);
    }

    public void inANombreExp7(ANombreExp7 node) {
        defaultIn(node);
    }

    public void outANombreExp7(ANombreExp7 node) {
        defaultOut(node);
    }

    @Override
    public void caseANombreExp7(ANombreExp7 node) {
        inANombreExp7(node);
        if (node.getNombre() != null) {
            node.getNombre().apply(this);
        }
        outANombreExp7(node);
    }

    public void inAAppelfoncExp7(AAppelfoncExp7 node) {
        defaultIn(node);
    }

    public void outAAppelfoncExp7(AAppelfoncExp7 node) {
        defaultOut(node);
    }

    @Override
    public void caseAAppelfoncExp7(AAppelfoncExp7 node) {
        inAAppelfoncExp7(node);
        if (node.getId() != null) {
            node.getId().apply(this);
        }
        if (node.getPo() != null) {
            node.getPo().apply(this);
        }
        if (node.getListeexp() != null) {
            node.getListeexp().apply(this);
        }
        if (node.getPf() != null) {
            node.getPf().apply(this);
        }
        outAAppelfoncExp7(node);
    }

    public void inALireExp7(ALireExp7 node) {
        defaultIn(node);
    }

    public void outALireExp7(ALireExp7 node) {
        defaultOut(node);
    }

    @Override
    public void caseALireExp7(ALireExp7 node) {
        inALireExp7(node);
        if (node.getLire() != null) {
            node.getLire().apply(this);
        }
        if (node.getPo() != null) {
            node.getPo().apply(this);
        }
        if (node.getPf() != null) {
            node.getPf().apply(this);
        }
        outALireExp7(node);
    }

    public void inAVraiExp7(AVraiExp7 node) {
        defaultIn(node);
    }

    public void outAVraiExp7(AVraiExp7 node) {
        defaultOut(node);
    }

    @Override
    public void caseAVraiExp7(AVraiExp7 node) {
        inAVraiExp7(node);
        if (node.getVrai() != null) {
            node.getVrai().apply(this);
        }
        outAVraiExp7(node);
    }

    public void inAFauxExp7(AFauxExp7 node) {
        defaultIn(node);
    }

    public void outAFauxExp7(AFauxExp7 node) {
        defaultOut(node);
    }

    @Override
    public void caseAFauxExp7(AFauxExp7 node) {
        inAFauxExp7(node);
        if (node.getFaux() != null) {
            node.getFaux().apply(this);
        }
        outAFauxExp7(node);
    }

    public void inAIdVar(AIdVar node) {
        defaultIn(node);
    }

    public void outAIdVar(AIdVar node) {
        defaultOut(node);
    }

    @Override
    public void caseAIdVar(AIdVar node) {
        inAIdVar(node);
        if (node.getId() != null) {
            node.getId().apply(this);
        }
        outAIdVar(node);
    }

    public void inAIdbVar(AIdbVar node) {
        defaultIn(node);
    }

    public void outAIdbVar(AIdbVar node) {
        defaultOut(node);
    }

    @Override
    public void caseAIdbVar(AIdbVar node) {
        inAIdbVar(node);
        if (node.getId() != null) {
            node.getId().apply(this);
        }
        if (node.getCo() != null) {
            node.getCo().apply(this);
        }
        if (node.getExp() != null) {
            node.getExp().apply(this);
        }
        if (node.getCf() != null) {
            node.getCf().apply(this);
        }
        outAIdbVar(node);
    }

}
