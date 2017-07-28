
package com.example.ecommerce.data.reponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class OrderReponse {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("parent_id")
    @Expose
    private Integer parentId;
    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("order_key")
    @Expose
    private String orderKey;
    @SerializedName("created_via")
    @Expose
    private String createdVia;
    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("date_created")
    @Expose
    private String dateCreated;
    @SerializedName("date_created_gmt")
    @Expose
    private String dateCreatedGmt;
    @SerializedName("date_modified")
    @Expose
    private String dateModified;
    @SerializedName("date_modified_gmt")
    @Expose
    private String dateModifiedGmt;
    @SerializedName("discount_total")
    @Expose
    private String discountTotal;
    @SerializedName("discount_tax")
    @Expose
    private String discountTax;
    @SerializedName("shipping_total")
    @Expose
    private String shippingTotal;
    @SerializedName("shipping_tax")
    @Expose
    private String shippingTax;
    @SerializedName("cart_tax")
    @Expose
    private String cartTax;
    @SerializedName("total")
    @Expose
    private String total;
    @SerializedName("total_tax")
    @Expose
    private String totalTax;
    @SerializedName("prices_include_tax")
    @Expose
    private Boolean pricesIncludeTax;
    @SerializedName("customer_id")
    @Expose
    private Integer customerId;
    @SerializedName("customer_ip_address")
    @Expose
    private String customerIpAddress;
    @SerializedName("customer_user_agent")
    @Expose
    private String customerUserAgent;
    @SerializedName("customer_note")
    @Expose
    private String customerNote;
    @SerializedName("billing")
    @Expose
    private Billing billing;
    @SerializedName("shipping")
    @Expose
    private Shipping shipping;
    @SerializedName("payment_method")
    @Expose
    private String paymentMethod;
    @SerializedName("payment_method_title")
    @Expose
    private String paymentMethodTitle;
    @SerializedName("transaction_id")
    @Expose
    private String transactionId;
    @SerializedName("date_paid")
    @Expose
    private Object datePaid;
    @SerializedName("date_paid_gmt")
    @Expose
    private Object datePaidGmt;
    @SerializedName("date_completed")
    @Expose
    private Object dateCompleted;
    @SerializedName("date_completed_gmt")
    @Expose
    private Object dateCompletedGmt;
    @SerializedName("cart_hash")
    @Expose
    private String cartHash;
    @SerializedName("meta_data")
    @Expose
    private List<Object> metaData = null;
    @SerializedName("line_items")
    @Expose
    private List<LineItem> lineItems = null;
    @SerializedName("tax_lines")
    @Expose
    private List<Object> taxLines = null;
    @SerializedName("shipping_lines")
    @Expose
    private List<Object> shippingLines = null;
    @SerializedName("fee_lines")
    @Expose
    private List<Object> feeLines = null;
    @SerializedName("coupon_lines")
    @Expose
    private List<Object> couponLines = null;
    @SerializedName("refunds")
    @Expose
    private List<Object> refunds = null;
    @SerializedName("_links")
    @Expose
    private Links links;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OrderReponse withId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public OrderReponse withParentId(Integer parentId) {
        this.parentId = parentId;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public OrderReponse withNumber(String number) {
        this.number = number;
        return this;
    }

    public String getOrderKey() {
        return orderKey;
    }

    public void setOrderKey(String orderKey) {
        this.orderKey = orderKey;
    }

    public OrderReponse withOrderKey(String orderKey) {
        this.orderKey = orderKey;
        return this;
    }

    public String getCreatedVia() {
        return createdVia;
    }

    public void setCreatedVia(String createdVia) {
        this.createdVia = createdVia;
    }

    public OrderReponse withCreatedVia(String createdVia) {
        this.createdVia = createdVia;
        return this;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public OrderReponse withVersion(String version) {
        this.version = version;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public OrderReponse withStatus(String status) {
        this.status = status;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public OrderReponse withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public OrderReponse withDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public String getDateCreatedGmt() {
        return dateCreatedGmt;
    }

    public void setDateCreatedGmt(String dateCreatedGmt) {
        this.dateCreatedGmt = dateCreatedGmt;
    }

    public OrderReponse withDateCreatedGmt(String dateCreatedGmt) {
        this.dateCreatedGmt = dateCreatedGmt;
        return this;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    public OrderReponse withDateModified(String dateModified) {
        this.dateModified = dateModified;
        return this;
    }

    public String getDateModifiedGmt() {
        return dateModifiedGmt;
    }

    public void setDateModifiedGmt(String dateModifiedGmt) {
        this.dateModifiedGmt = dateModifiedGmt;
    }

    public OrderReponse withDateModifiedGmt(String dateModifiedGmt) {
        this.dateModifiedGmt = dateModifiedGmt;
        return this;
    }

    public String getDiscountTotal() {
        return discountTotal;
    }

    public void setDiscountTotal(String discountTotal) {
        this.discountTotal = discountTotal;
    }

    public OrderReponse withDiscountTotal(String discountTotal) {
        this.discountTotal = discountTotal;
        return this;
    }

    public String getDiscountTax() {
        return discountTax;
    }

    public void setDiscountTax(String discountTax) {
        this.discountTax = discountTax;
    }

    public OrderReponse withDiscountTax(String discountTax) {
        this.discountTax = discountTax;
        return this;
    }

    public String getShippingTotal() {
        return shippingTotal;
    }

    public void setShippingTotal(String shippingTotal) {
        this.shippingTotal = shippingTotal;
    }

    public OrderReponse withShippingTotal(String shippingTotal) {
        this.shippingTotal = shippingTotal;
        return this;
    }

    public String getShippingTax() {
        return shippingTax;
    }

    public void setShippingTax(String shippingTax) {
        this.shippingTax = shippingTax;
    }

    public OrderReponse withShippingTax(String shippingTax) {
        this.shippingTax = shippingTax;
        return this;
    }

    public String getCartTax() {
        return cartTax;
    }

    public void setCartTax(String cartTax) {
        this.cartTax = cartTax;
    }

    public OrderReponse withCartTax(String cartTax) {
        this.cartTax = cartTax;
        return this;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public OrderReponse withTotal(String total) {
        this.total = total;
        return this;
    }

    public String getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(String totalTax) {
        this.totalTax = totalTax;
    }

    public OrderReponse withTotalTax(String totalTax) {
        this.totalTax = totalTax;
        return this;
    }

    public Boolean getPricesIncludeTax() {
        return pricesIncludeTax;
    }

    public void setPricesIncludeTax(Boolean pricesIncludeTax) {
        this.pricesIncludeTax = pricesIncludeTax;
    }

    public OrderReponse withPricesIncludeTax(Boolean pricesIncludeTax) {
        this.pricesIncludeTax = pricesIncludeTax;
        return this;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public OrderReponse withCustomerId(Integer customerId) {
        this.customerId = customerId;
        return this;
    }

    public String getCustomerIpAddress() {
        return customerIpAddress;
    }

    public void setCustomerIpAddress(String customerIpAddress) {
        this.customerIpAddress = customerIpAddress;
    }

    public OrderReponse withCustomerIpAddress(String customerIpAddress) {
        this.customerIpAddress = customerIpAddress;
        return this;
    }

    public String getCustomerUserAgent() {
        return customerUserAgent;
    }

    public void setCustomerUserAgent(String customerUserAgent) {
        this.customerUserAgent = customerUserAgent;
    }

    public OrderReponse withCustomerUserAgent(String customerUserAgent) {
        this.customerUserAgent = customerUserAgent;
        return this;
    }

    public String getCustomerNote() {
        return customerNote;
    }

    public void setCustomerNote(String customerNote) {
        this.customerNote = customerNote;
    }

    public OrderReponse withCustomerNote(String customerNote) {
        this.customerNote = customerNote;
        return this;
    }

    public Billing getBilling() {
        return billing;
    }

    public void setBilling(Billing billing) {
        this.billing = billing;
    }

    public OrderReponse withBilling(Billing billing) {
        this.billing = billing;
        return this;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    public OrderReponse withShipping(Shipping shipping) {
        this.shipping = shipping;
        return this;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public OrderReponse withPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    public String getPaymentMethodTitle() {
        return paymentMethodTitle;
    }

    public void setPaymentMethodTitle(String paymentMethodTitle) {
        this.paymentMethodTitle = paymentMethodTitle;
    }

    public OrderReponse withPaymentMethodTitle(String paymentMethodTitle) {
        this.paymentMethodTitle = paymentMethodTitle;
        return this;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public OrderReponse withTransactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    public Object getDatePaid() {
        return datePaid;
    }

    public void setDatePaid(Object datePaid) {
        this.datePaid = datePaid;
    }

    public OrderReponse withDatePaid(Object datePaid) {
        this.datePaid = datePaid;
        return this;
    }

    public Object getDatePaidGmt() {
        return datePaidGmt;
    }

    public void setDatePaidGmt(Object datePaidGmt) {
        this.datePaidGmt = datePaidGmt;
    }

    public OrderReponse withDatePaidGmt(Object datePaidGmt) {
        this.datePaidGmt = datePaidGmt;
        return this;
    }

    public Object getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(Object dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public OrderReponse withDateCompleted(Object dateCompleted) {
        this.dateCompleted = dateCompleted;
        return this;
    }

    public Object getDateCompletedGmt() {
        return dateCompletedGmt;
    }

    public void setDateCompletedGmt(Object dateCompletedGmt) {
        this.dateCompletedGmt = dateCompletedGmt;
    }

    public OrderReponse withDateCompletedGmt(Object dateCompletedGmt) {
        this.dateCompletedGmt = dateCompletedGmt;
        return this;
    }

    public String getCartHash() {
        return cartHash;
    }

    public void setCartHash(String cartHash) {
        this.cartHash = cartHash;
    }

    public OrderReponse withCartHash(String cartHash) {
        this.cartHash = cartHash;
        return this;
    }

    public List<Object> getMetaData() {
        return metaData;
    }

    public void setMetaData(List<Object> metaData) {
        this.metaData = metaData;
    }

    public OrderReponse withMetaData(List<Object> metaData) {
        this.metaData = metaData;
        return this;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public OrderReponse withLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
        return this;
    }

    public List<Object> getTaxLines() {
        return taxLines;
    }

    public void setTaxLines(List<Object> taxLines) {
        this.taxLines = taxLines;
    }

    public OrderReponse withTaxLines(List<Object> taxLines) {
        this.taxLines = taxLines;
        return this;
    }

    public List<Object> getShippingLines() {
        return shippingLines;
    }

    public void setShippingLines(List<Object> shippingLines) {
        this.shippingLines = shippingLines;
    }

    public OrderReponse withShippingLines(List<Object> shippingLines) {
        this.shippingLines = shippingLines;
        return this;
    }

    public List<Object> getFeeLines() {
        return feeLines;
    }

    public void setFeeLines(List<Object> feeLines) {
        this.feeLines = feeLines;
    }

    public OrderReponse withFeeLines(List<Object> feeLines) {
        this.feeLines = feeLines;
        return this;
    }

    public List<Object> getCouponLines() {
        return couponLines;
    }

    public void setCouponLines(List<Object> couponLines) {
        this.couponLines = couponLines;
    }

    public OrderReponse withCouponLines(List<Object> couponLines) {
        this.couponLines = couponLines;
        return this;
    }

    public List<Object> getRefunds() {
        return refunds;
    }

    public void setRefunds(List<Object> refunds) {
        this.refunds = refunds;
    }

    public OrderReponse withRefunds(List<Object> refunds) {
        this.refunds = refunds;
        return this;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public OrderReponse withLinks(Links links) {
        this.links = links;
        return this;
    }

    public RequestBody getRequestBody() {
        JSONObject param = new JSONObject();
        try {
            param.put("customer_note", customerNote);
//            param.put("set_paid", true);



            param.put("shipping", shipping.getRequestBody());
            param.put("billing", billing.getRequestBody());
            param.put("status", "processing");

            if (getLineItems() != null && getLineItems().size() != 0) {
                JSONArray otherImagesArr = new JSONArray();
                for (LineItem s : getLineItems()) {
                    otherImagesArr.put(s.getRequestBody());
                }
                param.put("line_items", otherImagesArr);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return RequestBody.create(MediaType.parse("application/json"), param.toString());
    }
}
