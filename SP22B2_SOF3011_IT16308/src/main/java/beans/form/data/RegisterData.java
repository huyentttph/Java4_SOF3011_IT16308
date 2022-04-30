package beans.form.data;

public class RegisterData {
	public RegisterData(String ho_ten, int gioi_tinh, String dia_chi, String email, String password, String sdt,
			int loaiKH) {
		super();
		this.ho_ten = ho_ten;
		this.gioi_tinh = gioi_tinh;
		this.dia_chi = dia_chi;
		this.email = email;
		this.password = password;
		this.sdt = sdt;
		this.loaiKH = loaiKH;
	}

	private String ho_ten;
	private int gioi_tinh;
	private String dia_chi;
	private String email;
	private String password;
	private String sdt;
	private int loaiKH;

	public RegisterData() {
		super();
		// TODO Auto-generated constructor stub
	}

	// source- Generate getter and setter
	public String getHo_ten() {
		return ho_ten;
	}

	public void setHo_ten(String ho_ten) {
		this.ho_ten = ho_ten;
	}

	public int getGioi_tinh() {
		return gioi_tinh;
	}

	public void setGioi_tinh(int gioi_tinh) {
		this.gioi_tinh = gioi_tinh;
	}

	public String getDia_chi() {
		return dia_chi;
	}

	public void setDia_chi(String dia_chi) {
		this.dia_chi = dia_chi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public int getLoaiKH() {
		return loaiKH;
	}

	public void setLoaiKH(int loaiKH) {
		this.loaiKH = loaiKH;
	}

}
