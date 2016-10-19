package com.iota.curl;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * Created by gianluigi.davassi on 13.10.16.
 */
public class MinerTest {

    private static String in = "XWGITHVPWBSPFRNQUEYLQETIVCJKRIIDKUZ9CSXBH9BKKUZCOGNLPKZXZHEGGPPWLMQHKDDAHZBSFQTNCOEJMSOLMHRPRHNWEUUAEHJURKTFWZQPSBOJGCJHWUPQSYKTVLVFKFMNQWQ9DJPBFJGXKKPYRDXDRYFBY9BIGHEYNTX9VGJTCIRVYIQHPCMCIESIUCGKMMIWHBLNC9BC9JR9CLYCPZTXPNQJOXPUDJUZEQTGWVOIEWCHPAY9EPZYCHFRQPHRZ9UZACWRJBSMRKBC9JJQSHJHPPEEYBFPHTZRGVVLJHDZ9JGLXJARNHMLWIYSUXNXRALYCMPMYOAMCKWHKNNWZPYNFTOUQORGVJRTVUYG9MX9DHLGHXFATETWQJUFPL9FLVRKEXDMVWQJOLTIXHJKBDGAJPJAHPQHT9TMWIL9QNIUQ9FBIIFDA9GUPVKXRPDRHG9IAHPJI9JRMTBJYOGVP9HZM9PNWXNFKKBSFQCOEDPDAUNEZRAYCAMBZBDVTDCANUNGZTAOAXFEUMQMSCOQF9EEVXXTXEB9IVY9DVGHBEXHMDHGJXUMIDIDIPDIAPAOGEKLVBTUFTFRRSKSAXTONHVCLGYOUUKORNGKABDQBTDSPZOWK9QD9VCKTOGMYGIHZ9YT9WYHDONULDLLSILTEUGRLKRAQFXAXNDRGECKTAERXMYOMDADLSPIVLWWNMQQBY9FHRB9LOKZNVUNVHT9I9IOLGHXOTBGAVNMR9QFCDPLDGVFGTLAEOEIDXAPSFNHJIBLMXEDLQQBGEUYKLMKRGVFFJ9AFEFILQBRWHWOOVECRMRQTSEIUHDGXRJFVZXBXSTMQA9KDIEUF9HZXYRZVZYVVEPSKDGEYWBVSEVMUDJSGYIHTPNSPWWDFII9VHAPTJHWXOWTWWSVEEKIXXUPRTTIIOEOQHHROGJIZ9Y9DSQRUVDTDHFBZMIAFTYOBJUBCOFMDTOVDWRSGCIEE9YKJCTJFZGLTFNZHNNPSKDHZZUCNDSJN9RBUOR9MYHNVLTZR9ZPHLCGXUOMGLRXCNKYMPKUFITURZCHHRKNGUZHWV9EQGNEBEXPMIRAZC9JMQL9BMDWK9NXRDEVUETPKINKDQNIJ9GJNQZJEPBDIVBJIXQWYAZCMEKFD9RFA9HUXCUBHAAVPOBRVFXRNEXDNTAIFTYEZADSWMXWEHSUKDVCCMATIDCIOFUVQYNMOXKVIDNXLGUCKQN9WVJDMHRXTHVRSHJTYFUOGKTSTDXYLM9EGYYUPMBA9JASZKKPDATFKNGLUD9IQLWFRPYQYSENKYIVXICCIOTATRVUSDKCYUA9JRUMSTMMBBHFZVCPJICNRGQZIGHEFGFMXV9VBMBMLEFJSGRDNBVODMLKCOIGDIYGCQCAUDJNVBFZGMFBV9TGOWKIFIPUOKIMJNQEBWPYVFXHCKOULMPMBN9QKWGXNM9HOJOSBJDNJJKDJWKJUWVAHNJIORACILRICNHQOQNAA9UIUTABUYOCRHLSNEKKF9BJZKX9VCAOPXOUGYFLWDZYXRVMHAXTCGJFQFOMJMSHRICSYVLSHKYWPTRLXMN9TTNBZLUTLXIDHUDTOIJAYPJ9I9JRFAHT9WOLXSJ9LOKCFXGQFZWJKNEJWURGSNBVCZYAUOBDVANKBTDCEU9W9JDIYAYVGPNGAF9WFFJL9NEYEPMJQLIMDWDVNRXOSZQAGISZIBUKTNDUHVNHOCQ9EIMWSKLREYSAKEVPUYZKMSCEGCRZVBNXXXJSEBSESONCZDNKVKSPSUUYBTDRVAIFGFYXKYRSBOFHYSQNYBQWPRQV99GBRNXWNHBEWTEECUTWPYCEGNQVBXDHLTFLVROOWHYX9TVGZVVFAZJZONCLNTEFZRBPCWPGPIKNQLQMZE9Q9CPPROOMR9QSRSRBSGMFMQ9NX9DNOOGSYRECEADHOVEBOBJTVARVDQYV9PHSDFFQODUISDRWUTAFLGQJNFIAOHOMBNPVTILCSMRTZUTPHYV9NGLXCJKKUPBOJDBDG9OSBCFHUJDXZBSBNLEKWCYPVINVRNWSDDMDPRTYHOSTSADVDRWEXPROSUYPVYNVKOBZDXUAKKVIJQKZE9JZN9EVUG9LTFDANQMUBRXBHAPL9USL9INWZCVCBFPKACSNYSOITLJAWIMCTNSCHQ9JZMYMPRGKQLABOLIEORLCNBJQMFMEAUONZMWKAT9ECRHNIRFSFRIHMGZISIJMOT9HLMOVUOGNTBXHHFZNGFLITAQRCAGBFBFOBBSTYSZMQPV99999999999999999999DOMIOTATESTWOW9999999999999PUPOYVD99A99999999C99999999MZWEZVBGFKSBSHDXAVGAJEUHCSKSRJSHCGRGGOKIPWMPTKSIHRFBEBWWYOSUGME9THEKAFFOORCRADGAK999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999";
    private static String out = "XWGITHVPWBSPFRNQUEYLQETIVCJKRIIDKUZ9CSXBH9BKKUZCOGNLPKZXZHEGGPPWLMQHKDDAHZBSFQTNCOEJMSOLMHRPRHNWEUUAEHJURKTFWZQPSBOJGCJHWUPQSYKTVLVFKFMNQWQ9DJPBFJGXKKPYRDXDRYFBY9BIGHEYNTX9VGJTCIRVYIQHPCMCIESIUCGKMMIWHBLNC9BC9JR9CLYCPZTXPNQJOXPUDJUZEQTGWVOIEWCHPAY9EPZYCHFRQPHRZ9UZACWRJBSMRKBC9JJQSHJHPPEEYBFPHTZRGVVLJHDZ9JGLXJARNHMLWIYSUXNXRALYCMPMYOAMCKWHKNNWZPYNFTOUQORGVJRTVUYG9MX9DHLGHXFATETWQJUFPL9FLVRKEXDMVWQJOLTIXHJKBDGAJPJAHPQHT9TMWIL9QNIUQ9FBIIFDA9GUPVKXRPDRHG9IAHPJI9JRMTBJYOGVP9HZM9PNWXNFKKBSFQCOEDPDAUNEZRAYCAMBZBDVTDCANUNGZTAOAXFEUMQMSCOQF9EEVXXTXEB9IVY9DVGHBEXHMDHGJXUMIDIDIPDIAPAOGEKLVBTUFTFRRSKSAXTONHVCLGYOUUKORNGKABDQBTDSPZOWK9QD9VCKTOGMYGIHZ9YT9WYHDONULDLLSILTEUGRLKRAQFXAXNDRGECKTAERXMYOMDADLSPIVLWWNMQQBY9FHRB9LOKZNVUNVHT9I9IOLGHXOTBGAVNMR9QFCDPLDGVFGTLAEOEIDXAPSFNHJIBLMXEDLQQBGEUYKLMKRGVFFJ9AFEFILQBRWHWOOVECRMRQTSEIUHDGXRJFVZXBXSTMQA9KDIEUF9HZXYRZVZYVVEPSKDGEYWBVSEVMUDJSGYIHTPNSPWWDFII9VHAPTJHWXOWTWWSVEEKIXXUPRTTIIOEOQHHROGJIZ9Y9DSQRUVDTDHFBZMIAFTYOBJUBCOFMDTOVDWRSGCIEE9YKJCTJFZGLTFNZHNNPSKDHZZUCNDSJN9RBUOR9MYHNVLTZR9ZPHLCGXUOMGLRXCNKYMPKUFITURZCHHRKNGUZHWV9EQGNEBEXPMIRAZC9JMQL9BMDWK9NXRDEVUETPKINKDQNIJ9GJNQZJEPBDIVBJIXQWYAZCMEKFD9RFA9HUXCUBHAAVPOBRVFXRNEXDNTAIFTYEZADSWMXWEHSUKDVCCMATIDCIOFUVQYNMOXKVIDNXLGUCKQN9WVJDMHRXTHVRSHJTYFUOGKTSTDXYLM9EGYYUPMBA9JASZKKPDATFKNGLUD9IQLWFRPYQYSENKYIVXICCIOTATRVUSDKCYUA9JRUMSTMMBBHFZVCPJICNRGQZIGHEFGFMXV9VBMBMLEFJSGRDNBVODMLKCOIGDIYGCQCAUDJNVBFZGMFBV9TGOWKIFIPUOKIMJNQEBWPYVFXHCKOULMPMBN9QKWGXNM9HOJOSBJDNJJKDJWKJUWVAHNJIORACILRICNHQOQNAA9UIUTABUYOCRHLSNEKKF9BJZKX9VCAOPXOUGYFLWDZYXRVMHAXTCGJFQFOMJMSHRICSYVLSHKYWPTRLXMN9TTNBZLUTLXIDHUDTOIJAYPJ9I9JRFAHT9WOLXSJ9LOKCFXGQFZWJKNEJWURGSNBVCZYAUOBDVANKBTDCEU9W9JDIYAYVGPNGAF9WFFJL9NEYEPMJQLIMDWDVNRXOSZQAGISZIBUKTNDUHVNHOCQ9EIMWSKLREYSAKEVPUYZKMSCEGCRZVBNXXXJSEBSESONCZDNKVKSPSUUYBTDRVAIFGFYXKYRSBOFHYSQNYBQWPRQV99GBRNXWNHBEWTEECUTWPYCEGNQVBXDHLTFLVROOWHYX9TVGZVVFAZJZONCLNTEFZRBPCWPGPIKNQLQMZE9Q9CPPROOMR9QSRSRBSGMFMQ9NX9DNOOGSYRECEADHOVEBOBJTVARVDQYV9PHSDFFQODUISDRWUTAFLGQJNFIAOHOMBNPVTILCSMRTZUTPHYV9NGLXCJKKUPBOJDBDG9OSBCFHUJDXZBSBNLEKWCYPVINVRNWSDDMDPRTYHOSTSADVDRWEXPROSUYPVYNVKOBZDXUAKKVIJQKZE9JZN9EVUG9LTFDANQMUBRXBHAPL9USL9INWZCVCBFPKACSNYSOITLJAWIMCTNSCHQ9JZMYMPRGKQLABOLIEORLCNBJQMFMEAUONZMWKAT9ECRHNIRFSFRIHMGZISIJMOT9HLMOVUOGNTBXHHFZNGFLITAQRCAGBFBFOBBSTYSZMQPV99999999999999999999DOMIOTATESTWOW9999999999999PUPOYVD99A99999999C99999999MZWEZVBGFKSBSHDXAVGAJEUHCSKSRJSHCGRGGOKIPWMPTKSIHRFBEBWWYOSUGME9THEKAFFOORCRADGAKAUA999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999";

    @Test
    public void shouldMine() {
        final IotaCurlMiner iotacurl = new IotaCurlMiner();

        String mined = iotacurl.doCurlPowSingleThread(in, 5);
        System.err.println("Mined: ");

        System.err.println("in: " + in);
        System.err.println("ou: " + mined);
        Assert.assertEquals(out, mined);
    }

    @Test
    public void shouldMine9() {
        String out = "XWGITHVPWBSPFRNQUEYLQETIVCJKRIIDKUZ9CSXBH9BKKUZCOGNLPKZXZHEGGPPWLMQHKDDAHZBSFQTNCOEJMSOLMHRPRHNWEUUAEHJURKTFWZQPSBOJGCJHWUPQSYKTVLVFKFMNQWQ9DJPBFJGXKKPYRDXDRYFBY9BIGHEYNTX9VGJTCIRVYIQHPCMCIESIUCGKMMIWHBLNC9BC9JR9CLYCPZTXPNQJOXPUDJUZEQTGWVOIEWCHPAY9EPZYCHFRQPHRZ9UZACWRJBSMRKBC9JJQSHJHPPEEYBFPHTZRGVVLJHDZ9JGLXJARNHMLWIYSUXNXRALYCMPMYOAMCKWHKNNWZPYNFTOUQORGVJRTVUYG9MX9DHLGHXFATETWQJUFPL9FLVRKEXDMVWQJOLTIXHJKBDGAJPJAHPQHT9TMWIL9QNIUQ9FBIIFDA9GUPVKXRPDRHG9IAHPJI9JRMTBJYOGVP9HZM9PNWXNFKKBSFQCOEDPDAUNEZRAYCAMBZBDVTDCANUNGZTAOAXFEUMQMSCOQF9EEVXXTXEB9IVY9DVGHBEXHMDHGJXUMIDIDIPDIAPAOGEKLVBTUFTFRRSKSAXTONHVCLGYOUUKORNGKABDQBTDSPZOWK9QD9VCKTOGMYGIHZ9YT9WYHDONULDLLSILTEUGRLKRAQFXAXNDRGECKTAERXMYOMDADLSPIVLWWNMQQBY9FHRB9LOKZNVUNVHT9I9IOLGHXOTBGAVNMR9QFCDPLDGVFGTLAEOEIDXAPSFNHJIBLMXEDLQQBGEUYKLMKRGVFFJ9AFEFILQBRWHWOOVECRMRQTSEIUHDGXRJFVZXBXSTMQA9KDIEUF9HZXYRZVZYVVEPSKDGEYWBVSEVMUDJSGYIHTPNSPWWDFII9VHAPTJHWXOWTWWSVEEKIXXUPRTTIIOEOQHHROGJIZ9Y9DSQRUVDTDHFBZMIAFTYOBJUBCOFMDTOVDWRSGCIEE9YKJCTJFZGLTFNZHNNPSKDHZZUCNDSJN9RBUOR9MYHNVLTZR9ZPHLCGXUOMGLRXCNKYMPKUFITURZCHHRKNGUZHWV9EQGNEBEXPMIRAZC9JMQL9BMDWK9NXRDEVUETPKINKDQNIJ9GJNQZJEPBDIVBJIXQWYAZCMEKFD9RFA9HUXCUBHAAVPOBRVFXRNEXDNTAIFTYEZADSWMXWEHSUKDVCCMATIDCIOFUVQYNMOXKVIDNXLGUCKQN9WVJDMHRXTHVRSHJTYFUOGKTSTDXYLM9EGYYUPMBA9JASZKKPDATFKNGLUD9IQLWFRPYQYSENKYIVXICCIOTATRVUSDKCYUA9JRUMSTMMBBHFZVCPJICNRGQZIGHEFGFMXV9VBMBMLEFJSGRDNBVODMLKCOIGDIYGCQCAUDJNVBFZGMFBV9TGOWKIFIPUOKIMJNQEBWPYVFXHCKOULMPMBN9QKWGXNM9HOJOSBJDNJJKDJWKJUWVAHNJIORACILRICNHQOQNAA9UIUTABUYOCRHLSNEKKF9BJZKX9VCAOPXOUGYFLWDZYXRVMHAXTCGJFQFOMJMSHRICSYVLSHKYWPTRLXMN9TTNBZLUTLXIDHUDTOIJAYPJ9I9JRFAHT9WOLXSJ9LOKCFXGQFZWJKNEJWURGSNBVCZYAUOBDVANKBTDCEU9W9JDIYAYVGPNGAF9WFFJL9NEYEPMJQLIMDWDVNRXOSZQAGISZIBUKTNDUHVNHOCQ9EIMWSKLREYSAKEVPUYZKMSCEGCRZVBNXXXJSEBSESONCZDNKVKSPSUUYBTDRVAIFGFYXKYRSBOFHYSQNYBQWPRQV99GBRNXWNHBEWTEECUTWPYCEGNQVBXDHLTFLVROOWHYX9TVGZVVFAZJZONCLNTEFZRBPCWPGPIKNQLQMZE9Q9CPPROOMR9QSRSRBSGMFMQ9NX9DNOOGSYRECEADHOVEBOBJTVARVDQYV9PHSDFFQODUISDRWUTAFLGQJNFIAOHOMBNPVTILCSMRTZUTPHYV9NGLXCJKKUPBOJDBDG9OSBCFHUJDXZBSBNLEKWCYPVINVRNWSDDMDPRTYHOSTSADVDRWEXPROSUYPVYNVKOBZDXUAKKVIJQKZE9JZN9EVUG9LTFDANQMUBRXBHAPL9USL9INWZCVCBFPKACSNYSOITLJAWIMCTNSCHQ9JZMYMPRGKQLABOLIEORLCNBJQMFMEAUONZMWKAT9ECRHNIRFSFRIHMGZISIJMOT9HLMOVUOGNTBXHHFZNGFLITAQRCAGBFBFOBBSTYSZMQPV99999999999999999999DOMIOTATESTWOW9999999999999PUPOYVD99A99999999C99999999MZWEZVBGFKSBSHDXAVGAJEUHCSKSRJSHCGRGGOKIPWMPTKSIHRFBEBWWYOSUGME9THEKAFFOORCRADGAKADQA99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999";
        String mined = new IotaCurlMiner().doCurlPowSingleThread(in, 9);
        Assert.assertEquals(out, mined);
    }

    @Test
    public void shouldShift() {
        // java: 3 << 62 = -4611686018427387904
        // c: 3 << 62 = 13835058055282163712
        System.err.println(BigInteger.valueOf(3).shiftLeft(62));
        // only way to compare such big numbers (2 << 62) using literals is through strings.
        Assert.assertEquals("13835058055282163712", BigInteger.valueOf(3).shiftLeft(62).toString());
    }

    @Test
    public void shouldDefineMacroC() {

        for (long i = 0; i<1000_000; i++) {
            boolean t = IotaCurlMiner.lc(i) == IotaCurlMiner.c(BigInteger.valueOf(i)).longValue();
            Assert.assertTrue(t);
        }
    }

    @Test
    public void shouldDefineMacroD() {

        for (long i = 0; i<10000; i++) {
            for (long j = 0; j<10000; j++) {
                boolean t = IotaCurlMiner.ld(i,j) == IotaCurlMiner.d(BigInteger.valueOf(i), BigInteger.valueOf(j)).longValue();
                Assert.assertTrue(t);
            }
        }
    }

    private static final long [] doTransResult = {0, 708, 912, 340, 2336, 2668, 2384, 3224, 3968, 52, 868, 472, 1012, 1352, 3916, 3820, 3868, 2712, 140, 480};

    @Test
    public void shouldTransform() {
        int SIZE = 729;
        final IotaCurlMiner iotacurl = new IotaCurlMiner();
        BigInteger[] state = new BigInteger[SIZE];
        for (int i = 0; i<SIZE;i++) {
            state[i] = BigInteger.valueOf(i << 2);
        }
        System.err.println(Arrays.toString(state));
        //iotacurl.doPowTransform(state);
        System.err.println(Arrays.toString(state));
        System.err.println(Arrays.toString(doTransResult));

        // ref 0, 588, 3224, 3644, 4004, 3172, 780, 888, 844, 3328, 552, 980, 424,
        Long[] arr = Arrays.stream(state)
                .limit(20)
                .map(BigInteger::longValue)
                .toArray(Long[]::new);

        Long[] res = Arrays.stream(doTransResult)
                .map(Long::new)
                .boxed()
                .toArray(Long[]::new);

        Assert.assertTrue(Arrays.equals(arr, res));
    }


    // just for reference

    protected static BigInteger slowC(final BigInteger a) {
        return ((a.xor(a.shiftRight(1))).and(IotaCurlMiner.MASK1)).or((a.shiftLeft(1)).and(IotaCurlMiner.MASK2));
    }

    protected static BigInteger slowD(final BigInteger b, final BigInteger c) {
        return (c).xor(IotaCurlMiner.MASK2.and(b).and((b.and(c)).shiftLeft(1))).xor(IotaCurlMiner.MASK1.and(b.not()).and(((b.and(c)).shiftRight(1))));
    }

}




