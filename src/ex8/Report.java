package ex8;

public class Report implements IPdfReportGenerator,IExcelReportGenerator{
    @Override
    public void generateExcelReport() {
        // логика генерации Excel
    }

    @Override
    public void generatePdfReport() {
        // логика генерации PDF
    }
}
