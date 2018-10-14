package com.example.lucas.deliva.mechanism.connection.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

import com.example.lucas.deliva.R;


public class StepIndicator extends View {

    private static final int DEFAULT_STEP_RADIUS = 16;   //DP
    private static final int DEFAULT_STROKE_WIDTH = 6;  //DP
    private static final int DEFAULT_STEP_COUNT = 3;  //DP
    private static final int DEFAULT_TEXT_SIZE = 14;
    private static final int DEFAULT_CURRENT_POSITION = 0;
    private static final int DEFAULT_LINE_WIDTH = 10;
    private static final int DEFAULT_NEXT_COLOR = R.color.next_default;
    private static final int DEFAULT_STEP_COLOR = R.color.step_default;
    private static final int DEFAULT_TEXT_COLOR = R.color.text_default;
    private static final int DEFAULT_STROKE_COLOR = R.color.stroke_default;

    private int stepsCount = 1;
    private int currentStepPosition;
    private int textColor;
    private int textSize;
    private int lineWidth;

    private int radius;
    private int strokeWidth;
    private int strokeColor;
    private int nextColor;
    private int stepColor;

    private int currentRadius;
    private int currentStrokeWidth;
    private int currentStrokeColor;
    private int currentStepColor;
    private int currentTextColor;

    private boolean showPositionInsideText;

    private int centerY;
    private int startX;
    private int endX;
    private int stepDistance;
    private float offset;
    private int offsetPixel;
    private int pagerScrollState;

    private Paint pLine;
    private Paint pStroke;
    private Paint pText;
    private Paint pCircle;

    private final Rect textBounds = new Rect();
    private OnClickListener onClickListener;
    private float[] hsvCurrent = new float[3];
    private float[] hsvBG = new float[3];
    private float[] hsvProgress = new float[3];

    private boolean clickable = false;
    private boolean withViewpager;
    private ViewPagerOnChangeListener viewPagerChangeListener;
    private boolean disablePageChange;

    public StepIndicator(Context context) {
        super(context);
        init(context, null);
    }

    public StepIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public StepIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public StepIndicator(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }


    public interface OnClickListener {
        void onClick(final int position);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    private void init(Context context, AttributeSet attributeSet) {

        initAttributes(context, attributeSet);

        pLine = new Paint();
        pLine.setFlags(Paint.ANTI_ALIAS_FLAG);
        pLine.setStrokeWidth(lineWidth);

        pCircle = new Paint();
        pCircle.setFlags(Paint.ANTI_ALIAS_FLAG);

        pStroke = new Paint();
        pStroke.setColor(strokeColor);
        pStroke.setStrokeWidth(strokeWidth);
        pStroke.setStyle(Paint.Style.STROKE);
        pStroke.setFlags(Paint.ANTI_ALIAS_FLAG);

        pText = new Paint();
        pText.setColor(textColor);
        pText.setTextSize(textSize);
        pText.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
        pText.setTextAlign(Paint.Align.CENTER);
        pText.setFlags(Paint.ANTI_ALIAS_FLAG);

        if (radius > currentRadius) {
            setMinimumHeight(radius);
        } else {
            setMinimumHeight(currentRadius);
        }

        Color.colorToHSV(currentStepColor, hsvCurrent);
        Color.colorToHSV(nextColor, hsvBG);
        Color.colorToHSV(stepColor, hsvProgress);
        invalidate();
    }

    private void initAttributes(Context context, AttributeSet attributeSet) {
        TypedArray attr = context.obtainStyledAttributes(attributeSet, R.styleable.StepIndicator, 0, 0);
        if (attr == null) {
            return;
        }

        try {
            stepsCount = attr.getInt(R.styleable.StepIndicator_stepCount, DEFAULT_STEP_COUNT);
            currentStepPosition = attr.getInt(R.styleable.StepIndicator_currentStepPosition, DEFAULT_CURRENT_POSITION);
            textSize = attr.getDimensionPixelSize(R.styleable.StepIndicator_textSize, DEFAULT_TEXT_SIZE);
            lineWidth = (int) attr.getDimension(R.styleable.StepIndicator_lineWidth, dp2px(DEFAULT_LINE_WIDTH));
            nextColor = attr.getColor(R.styleable.StepIndicator_nextColor, ContextCompat.getColor(context, DEFAULT_NEXT_COLOR));

            radius = (int) attr.getDimension(R.styleable.StepIndicator_radius, dp2px(DEFAULT_STEP_RADIUS));
            strokeWidth = (int) attr.getDimension(R.styleable.StepIndicator_strokeWidth, dp2px(DEFAULT_STROKE_WIDTH));
            strokeColor = attr.getColor(R.styleable.StepIndicator_strokeColor, ContextCompat.getColor(context, DEFAULT_STROKE_COLOR));
            stepColor = attr.getColor(R.styleable.StepIndicator_stepColor, ContextCompat.getColor(context, DEFAULT_STEP_COLOR));
            textColor = attr.getColor(R.styleable.StepIndicator_textColor, ContextCompat.getColor(context, DEFAULT_TEXT_COLOR));

            currentRadius = (int) attr.getDimension(R.styleable.StepIndicator_currentRadius, dp2px(DEFAULT_STEP_RADIUS));
            currentStrokeWidth = (int) attr.getDimension(R.styleable.StepIndicator_currentStrokeWidth, dp2px(DEFAULT_STROKE_WIDTH));
            currentStrokeColor = attr.getColor(R.styleable.StepIndicator_currentStrokeColor, ContextCompat.getColor(context, DEFAULT_STROKE_COLOR));
            currentStepColor = attr.getColor(R.styleable.StepIndicator_currentStepColor, ContextCompat.getColor(context, DEFAULT_STEP_COLOR));
            currentTextColor = attr.getColor(R.styleable.StepIndicator_currentTextColor, ContextCompat.getColor(context, DEFAULT_TEXT_COLOR));

            showPositionInsideText = attr.getBoolean(R.styleable.StepIndicator_showPositionInsideText, false);
        } finally {
            attr.recycle();
        }
    }

    @SuppressLint("NewApi")
    protected float dp2px(float dp) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    public int getStepsCount() {
        return stepsCount;
    }

    public void setStepsCount(int stepsCount) {
        this.stepsCount = stepsCount;
        invalidate();
    }

    public int getCurrentStepPosition() {
        return currentStepPosition;
    }

    public void setCurrentStepPosition(int currentStepPosition) {
        this.currentStepPosition = currentStepPosition;
        invalidate();
    }

    @Override
    public boolean isClickable() {
        return clickable;
    }

    @Override
    public void setClickable(boolean clickable) {
        this.clickable = clickable;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setupWithViewPager(@NonNull ViewPager viewPager) {
        final PagerAdapter adapter = viewPager.getAdapter();
        if (adapter == null) {
            throw new IllegalArgumentException("ViewPager does not have a PagerAdapter set");
        }
        if (viewPagerChangeListener == null) {
            viewPagerChangeListener = new ViewPagerOnChangeListener(this);
        }
        withViewpager = true;
        // First we'll add Steps.
        setStepsCount(adapter.getCount());

        // Now we'll add our page change listener to the ViewPager
        viewPager.addOnPageChangeListener(viewPagerChangeListener);

        // Now we'll add a selected listener to set ViewPager's currentStepPosition item
        setOnClickListener(new ViewPagerOnSelectedListener(viewPager));

        viewPager.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getActionMasked() == MotionEvent.ACTION_MOVE) {
                    ((ViewPager) v).addOnPageChangeListener(viewPagerChangeListener);
                    disablePageChange = false;
                }
                return false;
            }
        });

        // Make sure we reflect the currently set ViewPager item
        if (adapter.getCount() > 0) {
            final int curItem = viewPager.getCurrentItem();
            if (getCurrentStepPosition() != curItem) {
                setCurrentStepPosition(curItem);
                invalidate();
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (stepsCount <= 1) {
            setVisibility(GONE);
            return;
        }
        super.onDraw(canvas);
        int pointX = startX;
        int pointOffset;

        // draw line
        for (int i = 0; i < stepsCount - 1; i++) {
            if (i < currentStepPosition) {
                // draw previous lines
                pLine.setColor(stepColor);
                canvas.drawLine(pointX, centerY, pointX + stepDistance, centerY, pLine);
            } else {
                // draw next lines
                pLine.setColor(nextColor);
                canvas.drawLine(pointX, centerY, pointX + stepDistance, centerY, pLine);
            }
            pointX = pointX + stepDistance;
        }

        // draw progress line
        if (offsetPixel != 0 && pagerScrollState == 1) {
            pointOffset = startX + (currentStepPosition * stepDistance);
            int drawOffset = pointOffset + offsetPixel;
            if (drawOffset >= startX && drawOffset <= endX) {
                if (offsetPixel < 0) {
                    pLine.setColor(nextColor);
                } else {
                    pLine.setColor(stepColor);
                }
                canvas.drawLine(pointOffset, centerY, drawOffset, centerY, pLine);
            }
        }

        // draw circle
        pointX = startX;
        for (int i = 0; i < stepsCount; i++) {
            if (i < currentStepPosition) {
                //draw previous step
                pCircle.setColor(stepColor);
                canvas.drawCircle(pointX, centerY, radius, pCircle);

                //draw transition
                if (i == currentStepPosition - 1 && offsetPixel < 0 && pagerScrollState == 1) {
                    pStroke.setColor(currentStrokeColor);
                    pStroke.setAlpha(255);
                    pStroke.setStrokeWidth(strokeWidth);
                    canvas.drawCircle(pointX, centerY, radius, pStroke);
                }
                pText.setColor(textColor);
            } else if (i == currentStepPosition) {
                pStroke.setColor(currentStrokeColor);
                //draw current step
                if (offsetPixel == 0 || pagerScrollState == 0) {
                    //set stroke default
                    pCircle.setColor(currentStepColor);
                    pStroke.setStrokeWidth(currentStrokeWidth);
                    pStroke.setAlpha(255);
                } else if (offsetPixel < 0) {
                    pCircle.setColor(currentStepColor);
                    pStroke.setStrokeWidth(currentStrokeWidth);
                    pStroke.setAlpha(Math.round(offset * 255f));
                } else {
                    //set stroke transition
                    pCircle.setColor(currentStepColor);
                    pStroke.setStrokeWidth(currentStrokeWidth);
                    pStroke.setAlpha(255 - Math.round(offset * 255f));
                }
                canvas.drawCircle(pointX, centerY, currentRadius, pCircle);
                canvas.drawCircle(pointX, centerY, currentRadius, pStroke);
                pText.setColor(currentTextColor);
            } else {
                //draw next step
                pCircle.setColor(nextColor);
                pStroke.setColor(strokeColor);
                pStroke.setStrokeWidth(strokeWidth);

                canvas.drawCircle(pointX, centerY, radius, pCircle);
                canvas.drawCircle(pointX, centerY, radius, pStroke);
                pText.setColor(textColor);
            }

            if (showPositionInsideText) {
                drawTextCentred(canvas, pText, String.valueOf(i + 1), pointX, centerY);
            }
            pointX = pointX + stepDistance;
        }

    }

    private void drawTextCentred(Canvas canvas, Paint paint, String text, float cx, float cy) {
        paint.getTextBounds(text, 0, text.length(), textBounds);
        canvas.drawText(text, cx, cy - textBounds.exactCenterY(), paint);
    }

    private int getColorToBG(float offset) {
        offset = Math.abs(offset);
        float[] hsv = new float[3];
        hsv[0] = hsvBG[0] + (hsvCurrent[0] - hsvBG[0]) * offset;
        hsv[1] = hsvBG[1] + (hsvCurrent[1] - hsvBG[1]) * offset;
        hsv[2] = hsvBG[2] + (hsvCurrent[2] - hsvBG[2]) * offset;
        return Color.HSVToColor(hsv);
    }

    private int getColorToProgress(float offset) {
        offset = Math.abs(offset);
        float[] hsv = new float[3];
        hsv[0] = hsvCurrent[0] + (hsvProgress[0] - hsvCurrent[0]) * offset;
        hsv[1] = hsvCurrent[1] + (hsvProgress[1] - hsvCurrent[1]) * offset;
        hsv[2] = hsvCurrent[2] + (hsvProgress[2] - hsvCurrent[2]) * offset;
        return Color.HSVToColor(hsv);
    }

    private void setOffset(float offset, int position) {
        this.offset = offset;
        offsetPixel = Math.round(stepDistance * offset);
        if (currentStepPosition > position) {
            offsetPixel = offsetPixel - stepDistance;
        } else {
            currentStepPosition = position;
        }

        invalidate();
    }

    private void setPagerScrollState(int pagerScrollState) {
        this.pagerScrollState = pagerScrollState;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (!clickable)
            return super.onTouchEvent(event);
        int pointX = startX;
        int xTouch;
        int yTouch;
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                xTouch = (int) event.getX(0);
                yTouch = (int) event.getY(0);
                for (int i = 0; i < stepsCount; i++) {
                    if (Math.abs(xTouch - pointX) < radius + 5 && Math.abs(yTouch - centerY) < radius + 5) {
                        if (!withViewpager) {
                            setCurrentStepPosition(i);
                        }

                        if (onClickListener != null) {
                            onClickListener.onClick(i);
                        }
                    }
                    pointX = pointX + stepDistance;
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        centerY = getHeight() / 2;
        startX = getWidth() / (stepsCount * 2);
        endX = getWidth() - (getWidth() / (stepsCount * 2));
        stepDistance = getWidth() / stepsCount;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerY = getHeight() / 2;
        startX = getWidth() / (stepsCount * 2);
        endX = getWidth() - (getWidth() / (stepsCount * 2));
        stepDistance = getWidth() / stepsCount;
        invalidate();
    }

    public class ViewPagerOnChangeListener implements ViewPager.OnPageChangeListener {
        private final StepIndicator stepIndicator;

        ViewPagerOnChangeListener(StepIndicator stepIndicator) {
            this.stepIndicator = stepIndicator;
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            if (!disablePageChange) {
                stepIndicator.setOffset(positionOffset, position);
            }
        }

        @Override
        public void onPageSelected(int position) {
            if (!disablePageChange) {
                stepIndicator.setCurrentStepPosition(position);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            stepIndicator.setPagerScrollState(state);
        }

    }

    public class ViewPagerOnSelectedListener implements OnClickListener {

        private final ViewPager mViewPager;

        ViewPagerOnSelectedListener(ViewPager viewPager) {
            mViewPager = viewPager;
        }

        @Override
        public void onClick(int position) {
            disablePageChange = true;
            setCurrentStepPosition(position);
            mViewPager.setCurrentItem(position);
        }
    }


    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        SavedState ss = new SavedState(superState);
        ss.currentStepPosition = this.currentStepPosition;
        ss.stepsCount = this.stepsCount;
        ss.textColor = this.textColor;
        ss.textSize = this.textSize;
        ss.nextColor = this.nextColor;
        ss.lineWidth = this.lineWidth;

        ss.radius = this.radius;
        ss.strokeWidth = this.strokeWidth;
        ss.strokeColor = this.strokeColor;
        ss.stepColor = this.stepColor;

        ss.currentRadius = this.currentRadius;
        ss.currentStrokeWidth = this.currentStrokeWidth;
        ss.currentStrokeColor = this.currentStrokeColor;
        ss.currentStepColor = this.currentStepColor;
        ss.currentTextColor = this.currentTextColor;
        return ss;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof SavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }

        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());

        this.currentStepPosition = ss.currentStepPosition;
        this.stepsCount = ss.stepsCount;
        this.textColor = ss.textColor;
        this.textSize = ss.textSize;
        this.nextColor = ss.nextColor;
        this.lineWidth = ss.lineWidth;

        this.radius = ss.radius;
        this.strokeWidth = ss.strokeWidth;
        this.strokeColor = ss.strokeColor;
        this.stepColor = ss.stepColor;

        this.currentRadius = ss.currentRadius;
        this.currentStrokeWidth = ss.currentStrokeWidth;
        this.currentStrokeColor = ss.currentStrokeColor;
        this.currentStepColor = ss.currentStepColor;
        this.currentTextColor = ss.currentTextColor;
    }

    private static class SavedState extends BaseSavedState {

        int currentStepPosition;
        int stepsCount;
        int textSize;
        int textColor;
        int nextColor;
        int lineWidth;

        int radius;
        int strokeWidth;
        int strokeColor;
        int stepColor;

        int currentRadius;
        int currentStrokeWidth;
        int currentStrokeColor;
        int currentStepColor;
        int currentTextColor;

        SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel in) {
            super(in);
            currentStepPosition = in.readInt();
            stepsCount = in.readInt();
            textColor = in.readInt();
            textSize = in.readInt();
            nextColor = in.readInt();
            lineWidth = in.readInt();

            radius = in.readInt();
            strokeWidth = in.readInt();
            strokeColor = in.readInt();
            stepColor = in.readInt();

            currentRadius = in.readInt();
            currentStrokeWidth = in.readInt();
            currentStrokeColor = in.readInt();
            currentStepColor = in.readInt();
            currentTextColor = in.readInt();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(currentStepPosition);
            dest.writeInt(stepsCount);
            dest.writeInt(textColor);
            dest.writeInt(textSize);
            dest.writeInt(nextColor);
            dest.writeInt(lineWidth);

            dest.writeInt(radius);
            dest.writeInt(strokeWidth);
            dest.writeInt(strokeColor);
            dest.writeInt(stepColor);

            dest.writeInt(currentRadius);
            dest.writeInt(currentStrokeWidth);
            dest.writeInt(currentStrokeColor);
            dest.writeInt(currentStepColor);
            dest.writeInt(currentTextColor);
        }

        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            @Override
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            @Override
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
    }

}