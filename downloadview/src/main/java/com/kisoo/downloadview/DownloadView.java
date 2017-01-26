package com.kisoo.downloadview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by KiSoo on 2016/12/19.
 */

public class DownloadView extends View {

    private int mColor;
    private int mProgress;
    private static final int circleWidth = 30;//绳子圆环的宽度
    private static final int circleHeight = 50;//绳子圆环的高度
    private static final int WOODEN_PAINT_WIDTH = 8;//绳子的粗度
    private static final int SHOW_PANEL = 0;//详情页的页面

    private int PANEL_SRC_HEIGHT = 56 * 2;
    private int PADDING = 24;
    private int PICTURE_PADDING = PADDING + 56;

    private int WOODEN_ROCK_HEIGHT = 32;
    private int woodenDistance = 15;

    private Paint mWoodenPaint,
            mPanelPaint,
            mPanelBackPaint,
            mWoodenBackPaint,
            mWoodenLinePaint,
            mWoodenLineBackPaint,
            mPanelSrcPaint;
    private final float mSpaceHeight;
    private final int mSpaceColor;

    private Bitmap panelSrc;

    private final int positionX1 = 108;
    private Canvas mCanvas;

    public DownloadView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.DownloadView);
        try {
            mColor = ta.getColor(R.styleable.DownloadView_panel_color, getResources().getColor(R.color.colorPanel));
            mProgress = ta.getInt(R.styleable.DownloadView_load_progress, 0);
            mSpaceHeight = ta.getDimension(R.styleable.DownloadView_space_height, 88);
            mSpaceColor = ta.getColor(R.styleable.DownloadView_space_color, getResources().getColor(R.color.colorBack));
            BitmapDrawable bitmapDrawable = (BitmapDrawable) ta.getDrawable(R.styleable.DownloadView_panel_src);
            if (null != bitmapDrawable) {
                panelSrc = bitmapDrawable.getBitmap();
            }
            initPaints();
        } finally {
            ta.recycle();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getX() < getMeasuredWidth() - PADDING
                && event.getX() > PADDING
                && event.getY() < getMeasuredHeight() - mSpaceHeight
                && event.getY() > mSpaceHeight) {
            //最右侧的矩形区域的点击事件
            if (event.getX() < getMeasuredWidth() - PADDING
                    && event.getX() > getMeasuredWidth() - PADDING - 80
                    && event.getY() < getMeasuredHeight() - mSpaceHeight - 10
                    && event.getY() > mSpaceHeight + 10) {


            }
            return super.onTouchEvent(event);
        } else {
            return !super.onTouchEvent(event);
        }
    }

    public int getPanelWidth() {
        return getWidth() - 2 * PICTURE_PADDING;
    }

    public int getPanelHeight() {
        return (int) (getHeight() - 2 * (mSpaceHeight + 64));
    }

    private void initPaints() {
        mWoodenPaint = new Paint();
        mWoodenPaint.setColor(getResources().getColor(R.color.colorWood));
        mWoodenPaint.setStrokeWidth(WOODEN_PAINT_WIDTH);
        mWoodenPaint.setStyle(Paint.Style.STROKE);
        mWoodenPaint.setAntiAlias(true);
        mWoodenPaint.setFlags(Paint.ANTI_ALIAS_FLAG);


        mWoodenBackPaint = new Paint();
        mWoodenBackPaint.setColor(getResources().getColor(R.color.colorWoodBack));
        mWoodenBackPaint.setStrokeWidth(4);
        mWoodenBackPaint.setStyle(Paint.Style.STROKE);
        mWoodenBackPaint.setAntiAlias(true);
        mWoodenBackPaint.setFlags(Paint.ANTI_ALIAS_FLAG);

        mWoodenLinePaint = new Paint(mWoodenPaint);
        mWoodenLinePaint.setStrokeWidth(WOODEN_PAINT_WIDTH / 2);

        mWoodenLineBackPaint = new Paint(mWoodenBackPaint);
        mWoodenLineBackPaint.setStrokeWidth(WOODEN_PAINT_WIDTH);

        mPanelPaint = new Paint();
        mPanelPaint.setColor(mColor);
        mPanelPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPanelPaint.setAntiAlias(true);
        mPanelPaint.setFlags(Paint.ANTI_ALIAS_FLAG);

        mPanelBackPaint = new Paint();
        mPanelBackPaint.setStrokeWidth(4);
        mPanelBackPaint.setColor(Color.parseColor("#C2C3C5"));
        mPanelBackPaint.setStyle(Paint.Style.STROKE);
        mPanelBackPaint.setAntiAlias(true);
        mPanelBackPaint.setFlags(Paint.ANTI_ALIAS_FLAG);

        mPanelSrcPaint = new Paint();
        mPanelSrcPaint.setStyle(Paint.Style.STROKE);
        mPanelSrcPaint.setAntiAlias(true);
        mPanelSrcPaint.setStrokeWidth(1);
        mPanelSrcPaint.setFlags(Paint.ANTI_ALIAS_FLAG);

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    //新添加：在measure方法中对wrap_content进行设置
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMeasureSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthMeasureSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMeasureSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightMeasureSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        int default_height = (int) ((mSpaceHeight + 64) * 2 + 64);
        if (widthMeasureSpecMode == MeasureSpec.AT_MOST && heightMeasureSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthMeasureSpecSize, default_height);
        } else if (widthMeasureSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthMeasureSpecSize, heightMeasureSpecSize);
        } else if (heightMeasureSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthMeasureSpecSize, default_height);
        }

    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawColor(Color.parseColor("#F7F7F7"));
        canvas.drawColor(mSpaceColor);

        drawPanel(canvas, PADDING, mSpaceHeight, canvas.getWidth() - PADDING, canvas.getHeight() - mSpaceHeight, 12, mPanelPaint);

        drawPanel(canvas, PADDING, mSpaceHeight, canvas.getWidth() - PADDING, canvas.getHeight() - mSpaceHeight, 12, mPanelBackPaint);
        if (panelSrc != null)
            canvas.drawBitmap(panelSrc, null,
                    new RectF(PICTURE_PADDING, mSpaceHeight + 56, canvas.getWidth() - PICTURE_PADDING, canvas.getHeight() - mSpaceHeight - 56),
                    mPanelSrcPaint);
        //画绳圈
        drawCircleWithX(canvas, circleWidth, circleHeight, positionX1, (int) mSpaceHeight, mWoodenPaint, true);
        drawCircleWithX(canvas, circleWidth - WOODEN_PAINT_WIDTH, circleHeight - WOODEN_PAINT_WIDTH, positionX1, (int) mSpaceHeight, mWoodenBackPaint, true);
        drawCircleWithX(canvas, circleWidth + WOODEN_PAINT_WIDTH, circleHeight + WOODEN_PAINT_WIDTH, positionX1, (int) mSpaceHeight, mWoodenBackPaint, true);
        drawCircleWithX(canvas, circleWidth, circleHeight, canvas.getWidth() - positionX1, (int) mSpaceHeight, mWoodenPaint, true);
        drawCircleWithX(canvas, circleWidth - WOODEN_PAINT_WIDTH, circleHeight - WOODEN_PAINT_WIDTH, canvas.getWidth() - positionX1, (int) mSpaceHeight, mWoodenBackPaint, true);
        drawCircleWithX(canvas, circleWidth + WOODEN_PAINT_WIDTH, circleHeight + WOODEN_PAINT_WIDTH, canvas.getWidth() - positionX1, (int) mSpaceHeight, mWoodenBackPaint, true);
        //画绳子
        drawLineWithXY(canvas, woodenDistance, positionX1, WOODEN_PAINT_WIDTH, mWoodenLineBackPaint, true);
        drawLineWithXY(canvas, woodenDistance, positionX1, WOODEN_PAINT_WIDTH / 2, mWoodenLinePaint, true);
        drawLineWithXY(canvas, woodenDistance, canvas.getWidth() - positionX1, WOODEN_PAINT_WIDTH, mWoodenLineBackPaint, true);
        drawLineWithXY(canvas, woodenDistance, canvas.getWidth() - positionX1, WOODEN_PAINT_WIDTH / 2, mWoodenLinePaint, true);
        //画绳结
        drawRock(canvas, positionX1, (int) (mSpaceHeight - WOODEN_PAINT_WIDTH * 2 - woodenDistance), WOODEN_PAINT_WIDTH, WOODEN_ROCK_HEIGHT, mWoodenLineBackPaint);
        drawRock(canvas, positionX1, (int) (mSpaceHeight - WOODEN_PAINT_WIDTH * 2 - woodenDistance), WOODEN_PAINT_WIDTH / 2, WOODEN_ROCK_HEIGHT, mWoodenLinePaint);

        drawRock(canvas, positionX1, (int) (mSpaceHeight - WOODEN_PAINT_WIDTH * 4 - woodenDistance), WOODEN_PAINT_WIDTH, WOODEN_ROCK_HEIGHT, mWoodenLineBackPaint);
        drawRock(canvas, positionX1, (int) (mSpaceHeight - WOODEN_PAINT_WIDTH * 4 - woodenDistance), WOODEN_PAINT_WIDTH / 2, WOODEN_ROCK_HEIGHT, mWoodenLinePaint);
//
//        drawRock(canvas,canvas.getWidth()-positionX1,(int) (mSpaceHeight-WOODEN_PAINT_WIDTH*6-woodenDistance),WOODEN_PAINT_WIDTH,WOODEN_ROCK_HEIGHT,mWoodenLineBackPaint);
//        drawRock(canvas,canvas.getWidth()-positionX1,(int) (mSpaceHeight-WOODEN_PAINT_WIDTH*6-woodenDistance),WOODEN_PAINT_WIDTH/2,WOODEN_ROCK_HEIGHT,mWoodenLinePaint);

        drawRock(canvas, canvas.getWidth() - positionX1, (int) (mSpaceHeight - WOODEN_PAINT_WIDTH * 2 - woodenDistance), WOODEN_PAINT_WIDTH, WOODEN_ROCK_HEIGHT, mWoodenLineBackPaint);
        drawRock(canvas, canvas.getWidth() - positionX1, (int) (mSpaceHeight - WOODEN_PAINT_WIDTH * 2 - woodenDistance), WOODEN_PAINT_WIDTH / 2, WOODEN_ROCK_HEIGHT, mWoodenLinePaint);

        drawRock(canvas, canvas.getWidth() - positionX1, (int) (mSpaceHeight - WOODEN_PAINT_WIDTH * 4 - woodenDistance), WOODEN_PAINT_WIDTH, WOODEN_ROCK_HEIGHT, mWoodenLineBackPaint);
        drawRock(canvas, canvas.getWidth() - positionX1, (int) (mSpaceHeight - WOODEN_PAINT_WIDTH * 4 - woodenDistance), WOODEN_PAINT_WIDTH / 2, WOODEN_ROCK_HEIGHT, mWoodenLinePaint);
        //下面画绳圈
        drawCircleWithX(canvas, circleWidth, circleHeight, positionX1, (int) (canvas.getHeight() - mSpaceHeight), mWoodenPaint, false);
        drawCircleWithX(canvas, circleWidth - WOODEN_PAINT_WIDTH, circleHeight - WOODEN_PAINT_WIDTH, positionX1, (int) (canvas.getHeight() - mSpaceHeight), mWoodenBackPaint, false);
        drawCircleWithX(canvas, circleWidth + WOODEN_PAINT_WIDTH, circleHeight + WOODEN_PAINT_WIDTH, positionX1, (int) (canvas.getHeight() - mSpaceHeight), mWoodenBackPaint, false);
        drawCircleWithX(canvas, circleWidth, circleHeight, canvas.getWidth() - positionX1, (int) (canvas.getHeight() - mSpaceHeight), mWoodenPaint, false);
        drawCircleWithX(canvas, circleWidth - WOODEN_PAINT_WIDTH, circleHeight - WOODEN_PAINT_WIDTH, canvas.getWidth() - positionX1, (int) (canvas.getHeight() - mSpaceHeight), mWoodenBackPaint, false);
        drawCircleWithX(canvas, circleWidth + WOODEN_PAINT_WIDTH, circleHeight + WOODEN_PAINT_WIDTH, canvas.getWidth() - positionX1, (int) (canvas.getHeight() - mSpaceHeight), mWoodenBackPaint, false);
        //画下面绳子
        drawLineWithXY(canvas, woodenDistance, positionX1, WOODEN_PAINT_WIDTH, mWoodenLineBackPaint, false);
        drawLineWithXY(canvas, woodenDistance, positionX1, WOODEN_PAINT_WIDTH / 2, mWoodenLinePaint, false);
        drawLineWithXY(canvas, woodenDistance, canvas.getWidth() - positionX1, WOODEN_PAINT_WIDTH, mWoodenLineBackPaint, false);
        drawLineWithXY(canvas, woodenDistance, canvas.getWidth() - positionX1, WOODEN_PAINT_WIDTH / 2, mWoodenLinePaint, false);
        //画下面绳结
        drawRock(canvas, positionX1, (int) (canvas.getHeight() - mSpaceHeight + WOODEN_PAINT_WIDTH * 2 + woodenDistance), WOODEN_PAINT_WIDTH, WOODEN_ROCK_HEIGHT, mWoodenLineBackPaint);
        drawRock(canvas, positionX1, (int) (canvas.getHeight() - mSpaceHeight + WOODEN_PAINT_WIDTH * 2 + woodenDistance), WOODEN_PAINT_WIDTH / 2, WOODEN_ROCK_HEIGHT, mWoodenLinePaint);

        drawRock(canvas, positionX1, (int) (canvas.getHeight() - mSpaceHeight + WOODEN_PAINT_WIDTH * 4 + woodenDistance), WOODEN_PAINT_WIDTH, WOODEN_ROCK_HEIGHT, mWoodenLineBackPaint);
        drawRock(canvas, positionX1, (int) (canvas.getHeight() - mSpaceHeight + WOODEN_PAINT_WIDTH * 4 + woodenDistance), WOODEN_PAINT_WIDTH / 2, WOODEN_ROCK_HEIGHT, mWoodenLinePaint);

        drawRock(canvas, canvas.getWidth() - positionX1, (int) (canvas.getHeight() - mSpaceHeight + WOODEN_PAINT_WIDTH * 2 + woodenDistance), WOODEN_PAINT_WIDTH, WOODEN_ROCK_HEIGHT, mWoodenLineBackPaint);
        drawRock(canvas, canvas.getWidth() - positionX1, (int) (canvas.getHeight() - mSpaceHeight + WOODEN_PAINT_WIDTH * 2 + woodenDistance), WOODEN_PAINT_WIDTH / 2, WOODEN_ROCK_HEIGHT, mWoodenLinePaint);

        drawRock(canvas, canvas.getWidth() - positionX1, (int) (canvas.getHeight() - mSpaceHeight + WOODEN_PAINT_WIDTH * 4 + woodenDistance), WOODEN_PAINT_WIDTH, WOODEN_ROCK_HEIGHT, mWoodenLineBackPaint);
        drawRock(canvas, canvas.getWidth() - positionX1, (int) (canvas.getHeight() - mSpaceHeight + WOODEN_PAINT_WIDTH * 4 + woodenDistance), WOODEN_PAINT_WIDTH / 2, WOODEN_ROCK_HEIGHT, mWoodenLinePaint);

    }

    public void setPanelSrc(Bitmap bitmap) {
        if (this.panelSrc != bitmap) {
            this.panelSrc = bitmap;
            invalidate();
        }
    }

    private void drawPanel(Canvas canvas, int padding, float mSpaceHeight, int right, float bottom, int rx, Paint mSpacePaint) {
        RectF rectF = new RectF(padding, mSpaceHeight, right, bottom);
        canvas.drawRoundRect(rectF, rx, rx, mSpacePaint);
    }

    /**
     * 画绳子圈
     *
     * @param canvas
     * @param circleWidth
     * @param circleHeight
     * @param x
     * @param paint
     */
    private void drawCircleWithX(Canvas canvas, int circleWidth, int circleHeight, int x, int y, Paint paint, boolean top) {
        RectF rectF = new RectF(x - circleWidth / 2, y - circleHeight / 2, x + circleWidth / 2, y + circleHeight / 2);
        canvas.drawArc(rectF, top ? 90 : 0, 270, false, paint);
    }


    private void drawLineWithXY(Canvas canvas, int distance, int x, int width, Paint paint, boolean top) {
        drawPanel(canvas, x, top ? 0 : canvas.getHeight() - mSpaceHeight + distance, x + width / 2, top ? mSpaceHeight - distance : canvas.getHeight(), width / 2, paint);
    }

    private void drawRock(Canvas canvas, int x, int y, int width, int height, Paint paint) {
        drawPanel(canvas, x - height / 2, y - width / 2, x + height / 2, y + width / 2, width / 2, paint);
    }

    private void drawSkewView(Canvas canvas, int distance, int x, int width, Paint paint) {
//        RectF rectF = new RectF(x,0,x+width/2,mSpaceHeight-distance);
//        canvas.translate(canvas.getWidth()/2,canvas.getHeight()/2);
//        canvas.drawRoundRect(rectF,width/2,width/2,paint);
//        Path path = new Path();
//        path.moveTo();
    }

    public void setmProgress(int mProgress) {
        this.mProgress = mProgress;
        invalidate();
    }

}