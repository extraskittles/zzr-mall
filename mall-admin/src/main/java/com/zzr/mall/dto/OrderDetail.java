package com.zzr.mall.dto;

import com.zzr.mall.model.Order;
import com.zzr.mall.model.User;

import java.util.List;


public class OrderDetail extends Order {

        private List<OrderItemDetail> OrderItemDetails;
        private User user;
        private float prices;
        private int numbers;

        public List<OrderItemDetail> getOrderItemDetails() {
                return OrderItemDetails;
        }

        public void setOrderItemDetails(List<OrderItemDetail> OrderItemDetails) {
                this.OrderItemDetails = OrderItemDetails;
        }

        public User getUser() {
                return user;
        }

        public void setUser(User user) {
                this.user = user;
        }

        public float getPrices() {
                return prices;
        }

        public void setPrices(float prices) {
                this.prices = prices;
        }

        public int getNumbers() {
                return numbers;
        }

        public void setNumbers(int numbers) {
                this.numbers = numbers;
        }
}
