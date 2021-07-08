package by.training.service.creator;

import java.math.BigDecimal;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.training.task05.entity.Sphere;
import by.training.task05.entity.Sphere.CoordinateXYZ;
import by.training.task05.service.RepositoryLogic;
import by.training.task05.service.RepositoryLogicImpl;
import by.training.task05.service.ServiceException;

public class SphereLogicTestData {

    // data for calculating volume and square
    @DataProvider(name = "PositiveForCalculateSquare")
    public Object[] positiveForCalculateSquare() {
	final String tooBigNumber = "406107475438589519123941422554487189019473944930631978226951308003700262054839542192058031610686225738619427402615127623381257336884338381015609238870186252189945695037387643326488162121159343334688766970486862044574582201579278407122854972529146179594234696630039584444261978870262987264163144277563249173607404260822687957652072491414110445404323641679622170574358951705552367825021922807972776743072616380924240483442727296162243408477816855362304547302891037391972142330064404965893201073808055458607660916104325804305073494984301535492356082871455942948485613085915414379259573799887579481746389800964542305402880.0";
	final String anwerForFive = "314.1592653589793115997963468544185161590576171875";
	return new Object[][] {
		{ 1, new BigDecimal(12.5663706143591724639918538741767406463623046875) },
		{ Double.MAX_VALUE, new BigDecimal(tooBigNumber) },
		{ 5, new BigDecimal(anwerForFive) } };
    }

    @DataProvider(name = "PositiveForCalculateVolume")
    public Object[] positiveForCalculateVolume() {
	final String tooBigNumber = "24335220687073960694657378511053984442981708605716364767708308772649194892577576134878648548733563143915188585998655396058658006593170242973156561025172621559279682624136156922926417150689480026710726588285664412311271348117674279769432332020374064834488349888188418659692594612939534843268139067898587945560334779372722103041090026989390295484624189436784088861929460295523692186848870877962459671462618847669535177857226355960067013110231328025525046476123898430253427929513460929678509384534078814518305059974604779420479512209055430428001345007422308076663854410964288046219144423509346469844330448120029810318043117623492273140716563941630887009512469231387590212097078129154322355594057380435841990423306466164618086460887875228680475210009502207944460821908754802755460826005769900444278791963791661962546478931513074733680261624488156312624602195043118050899129818912859502886006969755576110364619409189909150117658624.0";
	final String anwerForFive = "523.59877559829881565889309058547951281070709228515625";
	final String anwerForOne = "4.18879020478639052527114472468383610248565673828125";
	return new Object[][] { { 1, new BigDecimal(anwerForOne) },
		{ Double.MAX_VALUE, new BigDecimal(tooBigNumber) },
		{ 5, new BigDecimal(anwerForFive) } };
    }

    @DataProvider(name = "NegativeForCalculateVolumeSquare")
    public Object[] NegativeForCalculateVolumeSquare() {

	return new Object[] { 0, -10, Double.NaN, Double.POSITIVE_INFINITY,
		Double.NEGATIVE_INFINITY };
    }

    // data for calculateCuttingVolumeRatio()
    @DataProvider(name = "positiveCalculateCuttingVolumeRatio")
    public Object[][] positiveForCalculateCuttingVolumeRatio() throws ServiceException {

	final CoordinateXYZ coordinate101 = new CoordinateXYZ(1, 0, 1);
	final CoordinateXYZ coordinate202 = new CoordinateXYZ(2, 0, 2);
	final CoordinateXYZ coordinate011 = new CoordinateXYZ(-1, -40, 1);
	final CoordinateXYZ coordinate077 = new CoordinateXYZ(-1, -68, 7);
	final CoordinateXYZ coordinate660 = new CoordinateXYZ(-6, -6, 0);
	final CoordinateXYZ coordinate770 = new CoordinateXYZ(7, 7, 0);

	RepositoryLogic repLogic = RepositoryLogicImpl.getInstance();

	// simple4___7.0___2.0___2.0___67.5
//	All0___0.0___0.0___0.0___67.5
//	AllMinus___-5.0___-68.0___-50.0___67.5
//	AllPlus___5.0___68.0___50.0___67.5
	final Sphere sphereZero = repLogic.takeSphereFromRepository("All0");
	final Sphere sphereMinus = repLogic.takeSphereFromRepository("AllMinus");
	final Sphere spherePlus = repLogic.takeSphereFromRepository("AllPlus");
	final Sphere sphereSimple = repLogic.takeSphereFromRepository("simple4");

	return new Object[][] {
		{ sphereZero, coordinate101, coordinate202, new BigDecimal("1.0000000000") },
		{ sphereMinus, coordinate011, coordinate077, new BigDecimal("1.1948712962") },
		{ spherePlus, coordinate660, coordinate770, new BigDecimal("20.7131825703") },
		{ sphereSimple, coordinate660, coordinate770, new BigDecimal("1.0929947679") },

	};
    }

    @DataProvider(name = "negativeCalculateCuttingVolumeRatio")
    public Object[][] negativeForCalculateCuttingVolumeRatio() throws ServiceException {

	// this plane will not cross the Sphere
	final CoordinateXYZ coordinate101 = new CoordinateXYZ(1, 68, 1);
	final CoordinateXYZ coordinate202 = new CoordinateXYZ(2, 68, 2);

	RepositoryLogic repLogic = RepositoryLogicImpl.getInstance();

//	All0___0.0___0.0___0.0___67.5
	final Sphere sphereZero = repLogic.takeSphereFromRepository("All0");

	return new Object[][] { { sphereZero, coordinate202, coordinate101 }, };
    }

}
