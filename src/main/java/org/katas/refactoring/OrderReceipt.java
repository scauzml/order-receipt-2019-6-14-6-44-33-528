package org.katas.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    public static final double TAXRATE = .10;
    public static final String SALES_TAX = "Sales Tax";
    public static final String TOTAL_AMOUNT = "Total Amount";
    public static final String TAG = "\t";
    private Order order;
    double totSalesTx = 0d;
    double tot = 0d;
    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();
        printHeaders(output, "======Printing Orders======\n");
        printCustomerNameAndAddress(output);
        for (LineItem lineItem : order.getLineItems()) {
            output.append(String.format("%s\t%.1f\t%d\t%.1f\n",lineItem.getDescription(),lineItem.getPrice(),
                    lineItem.getQuantity(),lineItem.totalAmount()));
            totalCount(lineItem);
        }
        pintTax(output);
        pintTag(output);
        return output.toString();
    }

    public void totalCount(LineItem lineItem) {
        double salesTax = lineItem.totalAmount() * TAXRATE;
        totSalesTx += salesTax;
        // calculate total amount of lineItem = price * quantity + 10 % sales tax
        tot += lineItem.totalAmount() + salesTax;
    }
    public void pintTax(StringBuilder output) {
        output.append(SALES_TAX).append(TAG).append(totSalesTx);

    }
    public void pintTag(StringBuilder output) {
        output.append(TOTAL_AMOUNT).append(TAG).append(tot);

    }
    public void printCustomerNameAndAddress(StringBuilder output) {
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
    }

    public void printHeaders(StringBuilder output, String s) {
        output.append(s);
    }
}