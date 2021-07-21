package com.memeor.mms.beans;

public enum RegistrationStatus {
	ACCEPTED {
		public String toString() {
			return "ACCEPTED";
		}
	},
	SUCCESS {
		public String toString() {
			return "SUCCESS";
		}
	},
	FAILED{
		public String toString() {
			return "FAILED";
		}
	},

}
