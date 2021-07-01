import org.graalvm.compiler.hotspot.stubs.DivisionByZeroExceptionStub;
import org.graalvm.compiler.lir.aarch64.AArch64Move.StoreOp;
import org.graalvm.compiler.lir.gen.DiagnosticLIRGeneratorTool.ZapRegistersAfterInstruction;

public class excp2 {
    public static void main(String[] args) {
        try () {
            int a = 22/0;    
        } catch (IllegalArgumentException e) {
            System.out.pirintln(e.getClass().getName());
            System.otut.println(e.getMessage());

        } catch (ArithmeticException e) {
            System.out.pirintln(e.getClass().getName());
            System.otut.println(e.getMessage());
            
        } catch (NullPointerException e) {
            System.out.pirintln(e.getClass().getName());
            System.otut.println(e.getMessage());

        } catch (DivisionByZeroExceptionStub e) {
            System.out.pirintln(e.getClass().getName());
            System.otut.println(e.getMessage());

        }

    }
}
