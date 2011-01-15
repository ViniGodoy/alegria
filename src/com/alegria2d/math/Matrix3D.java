package com.alegria2d.math;

/**
 * Represents a 3x3 matrix.
 * <p>
 * All mathematical operator methods comes with two signatures. The first one creates a copy of the matrix, prior to the
 * operation. The second one, suffixed with "Me", applies the operation the calling matrix.
 * <p>
 * This class also provides convenient access methods to retrieve the matrix elements as:
 * 
 * <pre>
 * [a b c]
 * [d e f]
 * [g h k]
 * </pre>
 * 
 * These methods are named {@link #a()}, {@link #b()}, {@link #c()}, {@link #d()}, {@link #e()}, {@link #f()},
 * {@link #g()}, {@link #h()} and {@link #k()}. The omission of the "get" prefix is intentional: the intention is to allow
 * a much clearer formula writing.
 * 
 * @author Vinicius G. Mendonca
 */
public class Matrix3D implements Cloneable {
   private float A[][] = null;

   /**
    * Creates a new Matrix3D and left A uninitialized.
    */
   private Matrix3D() {
   }

   /**
    * Creates a new 3D matrix with the given input values. The input matrix must have at least 3 rows and 3 columns. If
    * it's bigger than 3x3, only the first 3 rows and columns will be used.
    * 
    * @param matrix The input matrix.
    */
   public Matrix3D(float[][] matrix) {
      A = new float[3][3];
      for (int i = 0; i < 3; i++)
         for (int j = 0; j < 3; j++)
            A[i][j] = matrix[i][j];
   }

   /**
    * Copy constructor.
    * 
    * @param other The matrix to copy.
    * @see #clone()
    */
   public Matrix3D(Matrix3D other) {
      this(other.A);
   }

   /**
    * Creates a new matrix based on the given linear input values. It should be at least 9 values, that will be read as
    * a, b, c, d, e, f, g, h, k, generating following matrix:
    * 
    * <pre>
    * [a b c]
    * [d e f]
    * [g h k]
    * </pre>
    * 
    * @param values
    */
   public Matrix3D(float... values) {
      if (values.length < 9)
         throw new IllegalArgumentException("You must provide 9 values!");

      A = new float[3][3];
      for (int index = 0; index < 9; index++) {
         int i = index / 3;
         int j = index % 3;
         A[i][j] = values[index];
      }
   }

   /**
    * Returns the identity matrix:
    * 
    * <pre>
    * [1 0 0]
    * [0 1 0]
    * [0 0 1]
    * </pre>
    * 
    * @return the identity matrix.
    */
   public static Matrix3D newIdentity() {
      return new Matrix3D(1, 0, 0,
                         0, 1, 0,
                         0, 0, 1);
   }

   /**
    * Returns the element on the given row and column.
    * 
    * @param row The row to retrieve
    * @param col The column to retrieve
    * @return The element value
    */
   public float get(int row, int col) {
      return A[row][col];
   }

   /**
    * Change the value of the element in the given row and column
    * 
    * @param row The row
    * @param col The column
    * @param value The value to set.
    * @return This matrix.
    */
   public Matrix3D set(int row, int col, float value) {
      A[row][col] = value;
      return this;
   }

   /**
    * Returns the "a" element in the following mapping:
    * 
    * <pre>
    * [a b c]
    * [d e f]
    * [g h k]
    * </pre>
    * 
    * @return the A[0][0] element.
    */
   public float a() {
      return A[0][0];
   }

   /**
    * Returns the "b" element in the following mapping:
    * 
    * <pre>
    * [a b c]
    * [d e f]
    * [g h k]
    * </pre>
    * 
    * @return the A[0][1] element.
    */
   public float b() {
      return A[0][1];
   }

   /**
    * Returns the "c" element in the following mapping:
    * 
    * <pre>
    * [a b c]
    * [d e f]
    * [g h k]
    * </pre>
    * 
    * @return the A[0][2] element.
    */
   public float c() {
      return A[0][2];
   }

   /**
    * Returns the "d" element in the following mapping:
    * 
    * <pre>
    * [a b c]
    * [d e f]
    * [g h k]
    * </pre>
    * 
    * @return the A[1][0] element.
    */
   public float d() {
      return A[1][0];
   }

   /**
    * Returns the "e" element in the following mapping:
    * 
    * <pre>
    * [a b c]
    * [d e f]
    * [g h k]
    * </pre>
    * 
    * @return the A[1][1] element.
    */
   public float e() {
      return A[1][1];
   }

   /**
    * Returns the "e" element in the following mapping:
    * 
    * <pre>
    * [a b c]
    * [d e f]
    * [g h k]
    * </pre>
    * 
    * @return the A[1][1] element.
    */
   public float f() {
      return A[1][2];
   }

   /**
    * Returns the "g" element in the following mapping:
    * 
    * <pre>
    * [a b c]
    * [d e f]
    * [g h k]
    * </pre>
    * 
    * @return the A[2][0] element.
    */
   public float g() {
      return A[2][0];
   }

   /**
    * Returns the "h" element in the following mapping:
    * 
    * <pre>
    * [a b c]
    * [d e f]
    * [g h k]
    * </pre>
    * 
    * @return the A[2][1] element.
    */
   public float h() {
      return A[2][1];
   }

   /**
    * Returns the "k" element in the following mapping:
    * 
    * <pre>
    * [a b c]
    * [d e f]
    * [g h k]
    * </pre>
    * 
    * @return the A[2][2] element.
    */
   public float k() {
      return A[3][2];
   }

   /**
    * Sums this matrix with the given one.
    * 
    * @param other The matrix to sum
    * @return This matrix.
    * @see #plus(Matrix3D)
    */
   public Matrix3D plusMe(Matrix3D other) {
      for (int i = 0; i < 3; i++) {
         for (int j = 0; j < 3; j++) {
            A[i][j] += other.get(i, j);
         }
      }
      return this;
   }

   /**
    * Returns a new matrix that is the sum of this matrix with the given one.
    * 
    * @param other The matrix to sum
    * @return The new matrix.
    * @see #plusMe(Matrix3D)
    */
   public Matrix3D plus(Matrix3D other) {
      return clone().plusMe(other);
   }

   /**
    * Subtracts this matrix by the given one.
    * 
    * @param other The matrix that will be subtracted
    * @return This matrix.
    * @see #minus(Matrix3D)
    */
   public Matrix3D minusMe(Matrix3D other) {
      for (int i = 0; i < 3; i++) {
         for (int j = 0; j < 3; j++) {
            A[i][j] -= other.get(i, j);
         }
      }
      return this;
   }

   /**
    * Returns a new matrix that is the subtraction of this matrix by the given one.
    * 
    * @param other The matrix to subtract
    * @return The new matrix.
    * @see #minusMe(Matrix3D)
    */
   public Matrix3D minus(Matrix3D other) {
      return clone().minusMe(other);
   }

   /**
    * Creates a new matrix, that is equivalent to the multiplication of this matrix by the given one.
    * 
    * @param other The matrix to multiply to.
    * @return The new matrix.
    * @see #multiplyMe(Matrix3D)
    */
   public Matrix3D multiply(Matrix3D other) {
      float B[][] = other.A;
      float C[][] = new float[3][3];
      for (int i = 0; i < 3; ++i) {
         for (int j = 0; j < 3; ++j) {
            for (int k = 0; k < 3; ++k) {
               C[i][j] += A[i][k] * B[k][j];
            }
         }
      }
      Matrix3D matrix = new Matrix3D();
      matrix.A = C;
      return matrix;
   }

   /**
    * Multiplies this matrix by the given one.
    * 
    * @param other The matrix to multiply to.
    * @return This matrix.
    * @see #multiply(Matrix3D)
    */
   public Matrix3D multiplyMe(Matrix3D other) {
      A = multiply(other).A;
      return this;
   }

   /**
    * Performs a vector multiplication with this matrix. The vector is considered a column vector in homogeneous
    * coordinate system.
    * 
    * <pre>
    * [a b c]     [x]
    * [d e f]  x  [y]
    * [g h k]     [1]
    * </pre>
    * 
    * For line vectors, use the {@link Vector2D#multiply(Matrix3D) multiply} or {@link Vector2D#multiplyMe(Matrix3D)
    * multiplyMe} methods of {@link Vector2D} class.
    * 
    * @param vector The vector to multiply.
    * @return The resulting vector. The z coordinate is discarded.
    * @see Vector2D#multiply(float)
    * @see Vector2D#multiplyMe(float)
    */
   public Vector2D multiply(Vector2D vector) {
      float x = vector.getX();
      float y = vector.getY();

      return new Vector2D(
            x * a() + y * b() + c(),
            x * d() + y * e() + f());
   }

   /**
    * Multiplies this matrix by the given scalar.
    * 
    * @param scalar The scalar to multiply.
    * @return This matrix.
    * @see #multiply(float)
    */
   public Matrix3D multiplyMe(float scalar) {
      for (int i = 0; i < 3; i++) {
         for (int j = 0; j < 3; j++) {
            A[i][j] *= scalar;
         }
      }
      return this;
   }

   /**
    * Creates a new matrix, that is the product of this matrix and the given scalar.
    * 
    * @param scalar The scalar to multiply.
    * @return The new matrix.
    * @see #multiplyMe(float)
    */
   public Matrix3D multiply(float scalar) {
      return clone().multiplyMe(scalar);
   }

   /**
    * @return the determinant of this matrix.
    */
   public float getDeterminant() {
      return a() * (e() * k() - f() * h()) +
             b() * (f() * g() - k() * d()) +
             c() * (d() * h() - e() * g());
   }

   /**
    * @return True if this matrix is invertible, false if not.
    */
   public boolean isInvertible() {
      return getDeterminant() != 0;
   }

   /**
    * Inverses this matrix. Not all matrices are invertible, so check the {@link #isInvertible()} method prior to
    * calling this method if you are not sure if you can inverse this matrix or not.
    * 
    * <pre>
    * this * inverse = identity
    * </pre>
    * 
    * @return This matrix, after inversion. If the matrix is not invertible, the result will be undefined.
    * @see #isInvertible()
    * @see #inverse()
    */
   public Matrix3D inverseMe() {
      A = inverse().A;
      return this;
   }

   /**
    * Returns the inverse of this matrix. Not all matrices are invertible, so check the {@link #isInvertible()} method
    * prior to calling this method if you are not sure if you can inverse this matrix or not.
    * 
    * <pre>
    * this * inverse = identity
    * </pre>
    * 
    * @return The inverse matrix, if this matrix is invertible. An undefined matrix otherwise.
    * @see #isInvertible()
    * @see #inverseMe()
    */
   public Matrix3D inverse() {
      assert isInvertible() : "This matrix is not invertible!";

      Matrix3D inverse = new Matrix3D();
      inverse.A = new float[3][3];

      inverse.A[0][0] = e() * k() - f() * h();
      inverse.A[0][1] = c() * h() - b() * k();
      inverse.A[0][2] = b() * f() - c() * e();

      inverse.A[1][0] = f() * g() - d() * k();
      inverse.A[1][1] = a() * k() - c() * g();
      inverse.A[1][2] = c() * d() - a() * f();

      inverse.A[2][0] = d() * h() - e() * g();
      inverse.A[2][1] = b() * g() - a() * h();
      inverse.A[2][2] = a() * e() - b() * d();
      return inverse;
   }

   /**
    * Returns the transposed matrix. If this matrix is given by
    * 
    * <pre>
    * [a b c]
    * [d e f]
    * [g h k]
    * </pre>
    * 
    * The transposed will be:
    * 
    * <pre>
    * [a d g]
    * [b e h]
    * [c f k]
    * </pre>
    * 
    * @return The transpose matrix.
    */
   public Matrix3D transpose() {
      float[][] B = new float[3][3];
      for (int i = 0; i < 3; i++)
         for (int j = 0; j < 3; j++)
            B[i][j] = A[j][i];

      Matrix3D clone = new Matrix3D();
      clone.A = B;
      return clone;
   }

   /**
    * Transposes this matrix. If this matrix is:
    * 
    * <pre>
    * [a b c]
    * [d e f]
    * [g h k]
    * </pre>
    * 
    * After transposition it will become:
    * 
    * <pre>
    * [a d g]
    * [b e h]
    * [c f k]
    * </pre>
    * 
    * @return This matrix.
    */
   public Matrix3D transposeMe() {
      A = transpose().A;
      return this;
   }

   /**
    * Clones this matrix.
    */
   @Override
   public Matrix3D clone() {
      return new Matrix3D(this);
   }

   /**
    * @return this matrix in a 3x3 array.
    */
   public float[][] toArray() {
      return clone().A;
   }

   /**
    * Retrieves the given {@link MatrixRow}. So you can use like this:
    * 
    * <pre>
    * matrix.get(1).putAt(1, 10);
    * float value = matrix.getAt(1).getAt(2);
    * </pre>
    * 
    * Although this method is more useful when writing <a href="http://groovy.codehaus.org">Groovy</a> scripts:
    * 
    * <pre>
    * matrix[1][1] = 10;
    * def value = matrix[1][2];
    * </pre>
    * 
    * If that's not the case, prefer the {@link #get(int, int)} and {@link #set(int, int, float)} methods.
    * 
    * @param row The row to return
    * @return A class, representing the matrix row.
    * @see #get(int, int)
    * @see #set(int, int, float)
    * @see MatrixRow
    */
   public MatrixRow getAt(int row) {
      if (row < 0 || row > 2)
         throw new IndexOutOfBoundsException();      
      return new MatrixRow(row);
   }

   /**
    * Represents a row in this matrix.
    * 
    * @author Vinicius Godoy de Mendonca (ViniGodoy)
    */
   public class MatrixRow {
      private int row;

      
      public MatrixRow(int row) {
         this.row = row;
      }

      /**
       * Inserts the value in this row and in the given column.
       * 
       * @param col The column to insert.
       * @param value The value to insert.
       * @return The inserted value.
       */
      public float putAt(int col, float value) {
         A[row][col] = value;
         return value;
      }

      /**
       * Returns the value of this row that is in the given column.
       * @param col The column.
       * @return The value.
       */
      public float getAt(int col) {
         if (col < 0 || col > 2)
            throw new IllegalArgumentException();

         return A[row][col];
      }
   }
}
