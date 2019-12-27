public class UserFullyExpanded {
    public UserMultiPicture user;
    public boolean custom_picture;
    public String email;
    public String registration_status;
    public String force_refresh_at;
    public String locale;
    public String country_code;
    public String date_format;
    public String default_currency;
    public Integer default_group_id;
    public String notifications_read;
    public Integer notifications_count;
    public Notifications notifications;

    public class UserMultiPicture {
        public Integer id;
        public String first_name;
        public String last_name;
        public MultiPicture picture;

        public class MultiPicture {
            public String small;
            public String medium;
            public String large;
        }
    }

    public class Notifications {
        public boolean added_as_friend;
        public boolean added_to_group;
        public boolean expense_added;
        public boolean expense_updated;
        public boolean bills;
        public boolean payments;
        public boolean monthly_summary;
        public boolean announcements;
    }
}
